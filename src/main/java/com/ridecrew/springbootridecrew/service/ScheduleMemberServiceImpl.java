package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.ScheduleMember;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.ScheduleMemberRepository;

@Service
@Transactional
public class ScheduleMemberServiceImpl implements ScheduleMemberService {
	
	@Autowired
	private ScheduleMemberRepository scheduleMemberRepository;
	
	@Override
	public ApiResult<List<ScheduleMember>> getAll() {
		List<ScheduleMember> lists = new ArrayList<>();
		scheduleMemberRepository.findAll().forEach(e -> lists.add(e));
		return new ApiResult<>(lists);
	}

	@Override
	public ApiResult<ScheduleMember> add(ScheduleMember sm) {
		return new ApiResult<>(scheduleMemberRepository.save(sm));
	}

	@Override
	public ApiResult<Void> delete(Long scheduleId, Long memberId) {
		ScheduleMember scheduleMember = scheduleMemberRepository.findByScheduleIdAndMemberId(scheduleId, memberId);
		scheduleMemberRepository.delete(scheduleMember.getId());
		return new ApiResult<>();
	}

	@Override
	public ApiResult<List<ScheduleMember>> findByMemberId(Long memberId) {
		return new ApiResult<>(scheduleMemberRepository.findByMemberId(memberId));
	}

	@Override
	public ApiResult<List<ScheduleMember>> findByScheduleId(Long scheduleId) {
		return new ApiResult<>(scheduleMemberRepository.findByScheduleId(scheduleId));
	} 
	
}
