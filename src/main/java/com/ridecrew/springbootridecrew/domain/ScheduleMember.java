package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ScheduleMember implements Serializable{

	private static final long serialVersionUID = 8646646827157939504L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	@ManyToOne()
	@JoinColumn(name = "member_id")
	private Member member;
	
	
}
