package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService; 
	
	@RequestMapping(value = "/rest/v1/schedules", method = RequestMethod.POST)
	public ApiResult<Schedule> add(@RequestBody Schedule command) {
		try {
			Schedule schedule = scheduleService.add(command);
			return new ApiResult<>(schedule);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/schedules", method = RequestMethod.GET)
	public ApiResult<List<Schedule>> getSchedules() {
		try {
			List<Schedule> lists = scheduleService.getAllSchedules();
			return new ApiResult<>(lists);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}
