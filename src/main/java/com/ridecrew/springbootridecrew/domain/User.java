package com.ridecrew.springbootridecrew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user") // DBMS Table과 매핑
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // PK
	private Long id;

	@Column(length = 20, nullable = false) // 컬럼명칭과 동일해야되지만 다를경우 어노테이션으로 매칭
	private String name;

	@Column(name = "email", length = 20, nullable = false, unique = true)
	private String email___;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail___() {
		return email___;
	}

	public void setEmail___(String email___) {
		this.email___ = email___;
	}
	
	
}
