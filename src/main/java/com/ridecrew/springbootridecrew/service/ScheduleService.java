package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.domain.Member;

public interface ScheduleService {
	Schedule findOne(Long id);
	
	List<Schedule> getAllSchedules();
	
	Schedule add(Schedule schedule);
	
	Schedule update(Schedule schedule);
	
	void delete(Long id);
	
	List<Schedule> findByMember(Member member);
}
