package com.ridecrew.springbootridecrew.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Schedule;
import com.ridecrew.springbootridecrew.domain.User;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	List<Schedule> findByUser(User user);
}
