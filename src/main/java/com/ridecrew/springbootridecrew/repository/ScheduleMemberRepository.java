package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.ScheduleMember;

@Repository
public interface ScheduleMemberRepository extends CrudRepository<ScheduleMember, Long>{
	ScheduleMember findByScheduleIdAndMemberId(Long scheduleId, Long memberId);
}
