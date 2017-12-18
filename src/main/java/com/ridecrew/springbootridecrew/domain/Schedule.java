package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ridecrew.springbootridecrew.serializer.DateDeserializer;
import com.ridecrew.springbootridecrew.serializer.DateSerializer;
import com.ridecrew.springbootridecrew.serializer.TimeDeserializer;

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
	
	@NotNull
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private LocalDate date;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String startPoint;
	
	@Column(nullable = false)
	private String endPoint;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "hh:mm")
	@JsonDeserialize(using = TimeDeserializer.class)
	private Date startTime;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "hh:mm")
	@JsonDeserialize(using = TimeDeserializer.class)
	private Date endTime;
	
	@Lob
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
	private Date regDate;
	
}
