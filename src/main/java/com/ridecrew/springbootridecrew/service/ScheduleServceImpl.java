package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleServceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule findOne(Long id) {
		return scheduleRepository.findOne(id);
	}

	@Override
	public List<Schedule> getAllSchedules() {
		List<Schedule> lists = new ArrayList<>();
		scheduleRepository.findAll().forEach(e -> lists.add(e));
		return lists;
	}

	@Override
	public Schedule add(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule update(Schedule schedule) {
		return schedule;
	}

	@Override
	public void delete(Long id) {
		scheduleRepository.delete(id);
	}

	@Override
	public List<Schedule> findByMember(Member member) {
		return scheduleRepository.findByMember(member);
	}
	
	
	
}
