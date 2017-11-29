package com.ridecrew.springbootridecrew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.User;

/*@Repository	// create, update, delete는 Spring Data JPA interface메소드만 호출하면 내부에서 자동으로 처리
public interface UserRepository extends JpaRepository<User, Long>{ //JpaRepository<EntityClass, PK Type>
	
}*/

@Repository
public interface UserRepository extends CrudRepository<User, Long>{ //JpaRepository<EntityClass, PK Type>
	
}