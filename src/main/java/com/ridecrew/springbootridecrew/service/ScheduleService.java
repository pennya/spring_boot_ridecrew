package com.ridecrew.springbootridecrew.service;

import java.util.Date;
import java.util.List;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.domain.Member;

public interface ScheduleService {
	ApiResult<Schedule> findOne(Long id);
	
	ApiResult<List<Schedule>> getAllSchedules();
	
	ApiResult<Schedule> add(Schedule schedule);
	
	ApiResult<Schedule> update(Long id, Schedule schedule);
	
	ApiResult<Void> delete(Long id);
	
	ApiResult<List<Schedule>> findByMember(Member member);
	
	ApiResult<List<Schedule>> findByDate(Date date);
}
