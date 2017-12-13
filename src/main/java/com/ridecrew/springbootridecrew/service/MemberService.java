package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface MemberService {
	ApiResult<Member> findOne(Long id);

    ApiResult<List<Member>> getAllMembers();

    ApiResult<Member> create(Member member);

    ApiResult<Member> update(Long id, Member member);

    ApiResult<Void> delete(Long id);
    
    ApiResult<Member> findByEmail(String email);
    
    ApiResult<Member> findByDeviceId(String deviceId);
}
