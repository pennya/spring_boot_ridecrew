package com.ridecrew.springbootridecrew.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	List<Member> findByEmail(String email);
}