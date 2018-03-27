package com.ridecrew.springbootridecrew.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.ScheduleMember;

@Repository
public interface ScheduleMemberRepository extends CrudRepository<ScheduleMember, Long>{
	ScheduleMember findByScheduleIdAndMemberId(Long scheduleId, Long memberId);
	List<ScheduleMember> findByMemberId(Long memberId);
	List<ScheduleMember> findByScheduleId(Long scheduleId);
}
