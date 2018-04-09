package com.ridecrew.springbootridecrew.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.domain.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	List<Schedule> findByMember(Member member);
	List<Schedule> findByDate(LocalDate date);
	List<Schedule> findByMemberId(Long memberId);
}
