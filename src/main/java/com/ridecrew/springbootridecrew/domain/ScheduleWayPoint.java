package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "schedule_waypoint")
@Getter
@Setter
@ToString
public class ScheduleWayPoint implements Serializable{

	private static final long serialVersionUID = 8694255296482157157L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	@Column
	private int sort;
	
	@Column
	private String spot;
	
	@Column
	private String point;

}
