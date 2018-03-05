package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "member")
@Getter
@Setter
@ToString
public class Member implements Serializable {
	
	private static final long serialVersionUID = 389814181358557717L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;
	
	@Column
	private String pwd;

	@Column(nullable = false, unique = true)
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	@Column
	private int sex;
	
	@Column(nullable = false)
	private String nickName;
	
	@Column(nullable = false, unique = true)
	private String deviceId;
	
	/**
	 * 1		normal
	 * 2		facebook
	 * 3		google
	 * 4		naver
	 * 5		kakao
	 */
	@Column(name = "member_type", nullable = false)
	private int memberType;		
	
	@Column
	private String profileUrl;
	
	@OneToMany(mappedBy = "member", orphanRemoval = true)
	@JsonIgnore
	private List<Schedule> schedules;
	
	@OneToMany(mappedBy="member", orphanRemoval=true)
	@JsonIgnore
	private List<Gallery> galleries;
	
}
