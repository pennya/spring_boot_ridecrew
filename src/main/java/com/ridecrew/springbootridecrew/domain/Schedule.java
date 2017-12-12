package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule implements Serializable{

	private static final long serialVersionUID = -2124319570368831640L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Schedule_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date time;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String start;
	
	@Column(nullable = false)
	private String end;
	
	@Column(nullable = false)
	private String waypoint;
	
	@Column()
	private String content;
	
}
