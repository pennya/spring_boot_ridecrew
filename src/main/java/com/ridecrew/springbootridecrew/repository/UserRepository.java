package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{ //JpaRepository<EntityClass, PK Type>
	
}