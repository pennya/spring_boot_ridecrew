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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ridecrew.springbootridecrew.serializer.JsonDateSerializer;

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
	
	@ManyToOne()
	@JoinColumn(name = "member_id")
	private Member member;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date date;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String startPoint;
	
	@Column(nullable = false)
	private String endPoint;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date endTime;
	
	@Column
	private String descriptions;
	
	@Column
	private String picture;
	
	@Column
	private String startSpot;
	
	@Column
	private String endSpot;
	
	@Column
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date regDate;
	
}
