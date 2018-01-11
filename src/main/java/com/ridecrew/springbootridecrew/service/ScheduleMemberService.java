package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.ScheduleMember;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface ScheduleMemberService {
	
	ApiResult<List<ScheduleMember>> getAll();
	
	ApiResult<ScheduleMember> add(ScheduleMember sm);
	
	ApiResult<Void> delete(Long schedulePk, Long memberPk);
	
	ApiResult<List<ScheduleMember>> findByMemberId(Long memberId);
}
