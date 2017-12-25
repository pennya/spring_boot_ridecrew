package com.ridecrew.springbootridecrew.service;

import java.time.LocalDate;
import java.util.List;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface ScheduleService {
	ApiResult<Schedule> findOne(Long id);
	
	ApiResult<List<Schedule>> getAllSchedules();
	
	ApiResult<Schedule> add(Schedule schedule);
	
	ApiResult<Schedule> update(Long id, Schedule schedule);
	
	ApiResult<Void> delete(Long id);
	
	ApiResult<List<Schedule>> findByMemberId(Long memberId);
	
	ApiResult<List<Schedule>> findByMember(Member member);
	
	ApiResult<List<Schedule>> findByDate(LocalDate date);
	
	ApiResult<List<Schedule>> findByDates(String date);
}
