package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	Member findByEmail(String email);
	Member findByDeviceId(String deviceId);
}