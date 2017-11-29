package com.ridecrew.springbootridecrew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user") 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(length = 20, nullable = false) 
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
