package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.ScheduleMember;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.ScheduleMemberService;

@RestController
public class ScheduleMemberController {
	
	@Autowired
	private ScheduleMemberService scheduleMemberService;
	
	
	@RequestMapping(value = "rest/v1/schedule_members", method = RequestMethod.GET)
	public ApiResult<List<ScheduleMember>> getAll() {
		try {
			return scheduleMemberService.getAll();
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "rest/v1/schedule_members_by_member_id", method = RequestMethod.GET)
	public ApiResult<List<ScheduleMember>> getAllByMemberId(@RequestParam("memberId") Long memberId) {
		try {
			return scheduleMemberService.findByMemberId(memberId);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedule_members", method = RequestMethod.POST)
	public ApiResult<ScheduleMember> add(@RequestBody ScheduleMember sm) {
		try {
			return scheduleMemberService.add(sm);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedule_members", method = RequestMethod.DELETE)
	public ApiResult<Void> delete(@RequestParam("scheduleId") Long scheduleId, 
								@RequestParam("memberId") Long memberId ) {
		
		try {
			return scheduleMemberService.delete(scheduleId, memberId);
		} catch ( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
}
