package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.Member;

public interface MemberService {
	Member findOne(Long id);

    List<Member> getAllMembers();

    boolean create(Member member);

    Member update(Member member);

    void delete(Long id);
    
    List<Member> findByEmail(String email);
}
