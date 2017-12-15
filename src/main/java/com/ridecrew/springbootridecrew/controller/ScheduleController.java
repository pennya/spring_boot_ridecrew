package com.ridecrew.springbootridecrew.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value = "/rest/v1/schedules/{id}", method = RequestMethod.GET)
	public ApiResult<Schedule> findOne(@PathVariable("id") Long id) {
		try {
			return scheduleService.findOne(id);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules", method = RequestMethod.GET)
	public ApiResult<List<Schedule>> getSchedules() {
		try {
			return scheduleService.getAllSchedules();
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules", method = RequestMethod.POST)
	public ApiResult<Schedule> add(@RequestBody Schedule command) {
		try {
			return scheduleService.add(command);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules/{id}", method = RequestMethod.PUT)
	public ApiResult<Schedule> update(@PathVariable("id") Long id, @RequestBody Schedule command) {
		try {
			return scheduleService.update(id, command);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules/{id}", method = RequestMethod.DELETE)
	public ApiResult<Void> delete(@PathVariable("id") Long id) {
		try {
			return scheduleService.delete(id);
		} catch ( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules_by_member", method = RequestMethod.GET)
	public ApiResult<List<Schedule>> findByMemberId(@RequestParam("memberId") Long memberId) {
		try {
			return scheduleService.findByMemberId(memberId);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules_by_member", method = RequestMethod.POST)
	public ApiResult<List<Schedule>> findByMember(@RequestBody Member member) {
		try {
			return scheduleService.findByMember(member);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}


	@RequestMapping(value = "/rest/v1/schedules_by_date", method = RequestMethod.POST)
	public ApiResult<List<Schedule>> findByDate(@RequestBody Date date) {
		try {
			return scheduleService.findByDate(date);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}

}
