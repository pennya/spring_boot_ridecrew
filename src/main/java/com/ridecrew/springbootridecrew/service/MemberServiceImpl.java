package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.Member;
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
	public synchronized boolean create(Member member) {
		List<Member> list = memberRepository.findByEmail(member.getEmail());
		if(list.size() > 0) {
			return false;
		} else {
			memberRepository.save(member);
			return true;
		}
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
	public List<Member> findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
}
