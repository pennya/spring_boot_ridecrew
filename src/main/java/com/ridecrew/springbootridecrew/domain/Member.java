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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(name = "member_type", nullable = false)
	private int memberType;
	
	@OneToMany(mappedBy = "member", orphanRemoval = true)
	private List<Schedule> schedules;
}
