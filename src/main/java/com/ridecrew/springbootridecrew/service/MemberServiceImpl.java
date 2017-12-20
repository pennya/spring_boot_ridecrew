package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.model.ApiErrorCode;
import com.ridecrew.springbootridecrew.model.ApiErrorType;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.MemberRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public ApiResult<Member> findOne(Long id) {
		return new ApiResult<>(memberRepository.findOne(id));
	}

	@Override
	public ApiResult<List<Member>> getAllMembers() {
		List<Member> list = new ArrayList<>();
		memberRepository.findAll().forEach(e -> list.add(e));
		return new ApiResult<>(list);
	}

	@Override
	@Transactional
	public ApiResult<Member> create(Member member){
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_LOGIN_ID, "DUPLICATE LOGIN ID");
		}
		
		findMember = memberRepository.findByDeviceId(member.getDeviceId());
		if(findMember != null) {
			return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_DEVICE_ID, "DUPLICATE DEVICE ID");
		}
		
		return new ApiResult<>(memberRepository.save(member));
	}

	@Override
	public ApiResult<Member> update(Long id, Member member) {
		Member origin = memberRepository.findOne(id);
		if(origin == null) {
			return new ApiResult<>(ApiErrorType.INVALIDATE_INPUT, ApiErrorCode.NOT_FOUND, "MEMBER NOT FOUND. INVALID MEMBER PK");
		}
		origin.setDeviceId(member.getDeviceId());
		origin.setEmail(member.getEmail());
		origin.setMemberType(member.getMemberType());
		origin.setNickName(member.getNickName());
		origin.setPwd(member.getPwd());
		origin.setSex(member.getSex());
		
		return new ApiResult<>(memberRepository.save(origin));
	}

	@Override
	public ApiResult<Void> delete(Long id) {
		memberRepository.delete(id);
		return new ApiResult<>();
	}

	@Override
	public ApiResult<Member> findByEmail(String email) {
		return new ApiResult<>(memberRepository.findByEmail(email));
	}

	@Override
	public ApiResult<Member> findByDeviceId(String deviceId) {
		return new ApiResult<>(memberRepository.findByDeviceId(deviceId));
	}
}