package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
}
