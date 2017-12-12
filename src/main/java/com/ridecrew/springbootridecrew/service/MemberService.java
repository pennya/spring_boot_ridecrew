package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.exception.DuplicateLoginIdException;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface MemberService {
	Member findOne(Long id);

    List<Member> getAllMembers();

    ApiResult<Member> create(Member member) throws DuplicateLoginIdException;

    Member update(Member member);

    void delete(Long id);
    
    Member findByEmail(String email);
    
    Member findByDeviceId(String email);
}
