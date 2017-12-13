package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.model.ApiErrorCode;
import com.ridecrew.springbootridecrew.model.ApiErrorType;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleServceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public ApiResult<Schedule> findOne(Long id) {
		return new ApiResult<>(scheduleRepository.findOne(id));
	}

	@Override
	public ApiResult<List<Schedule>> getAllSchedules() {
		List<Schedule> lists = new ArrayList<>();
		scheduleRepository.findAll().forEach(e -> lists.add(e));
		return new ApiResult<>(lists);
	}

	@Override
	public ApiResult<Schedule> add(Schedule schedule) {
		return new ApiResult<>(scheduleRepository.save(schedule));
	}

	@Override
	public ApiResult<Schedule> update(Long id, Schedule schedule) {
		Schedule origin = scheduleRepository.findOne(id);
		if(origin == null) {
			return new ApiResult<>(ApiErrorType.INVALIDATE_INPUT, ApiErrorCode.NOT_FOUND, "SCHEDULE NOT FOUND. INVALID SCHEDULE PK");
		}
		origin = schedule;

		return new ApiResult<>(scheduleRepository.save(origin));
	}

	@Override
	public ApiResult<Void> delete(Long id) {
		scheduleRepository.delete(id);
		return new ApiResult<>();
	}

	@Override
	public ApiResult<List<Schedule>> findByMember(Member member) {
		return new ApiResult<>(scheduleRepository.findByMember(member));
	}

	@Override
	public ApiResult<List<Schedule>> findByDate(Date date) {
		return new ApiResult<>(scheduleRepository.findByDate(date));
	}
	
}
