package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.exception.DuplicateLoginIdException;
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
	public Member findOne(Long id) {
		return memberRepository.findOne(id);
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> list = new ArrayList<>();
		memberRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public ApiResult<Member> create(Member member) throws DuplicateLoginIdException{
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new DuplicateLoginIdException();
		}
		
		findMember = memberRepository.findByDeviceId(member.getDeviceId());
		if(findMember != null) {
			return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_CODE, "DUPLICATE DEVICE ID");
		}
		
		return new ApiResult<>(memberRepository.save(member));
	}

	@Override
	public Member update(Member member) {
		return member;
	}

	@Override
	public void delete(Long id) {
		memberRepository.delete(id);
	}

	@Override
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Override
	public Member findByDeviceId(String email) {
		return null;
	}
}
