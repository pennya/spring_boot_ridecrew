package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity(name = "user") 
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(nullable = false) 
	@NotEmpty(message = "Please provide your name")
	private String name;
	
	@Transient  // JSON output에는 안나옴. 데이터베이스에는 저장됨.
	@Column(nullable = false)
	private String pwd;

	@Column(nullable = false, unique = true)
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
