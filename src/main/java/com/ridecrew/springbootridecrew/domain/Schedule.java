package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ridecrew.springbootridecrew.serializer.DateDeserializer;
import com.ridecrew.springbootridecrew.serializer.DateSerializer;
import com.ridecrew.springbootridecrew.serializer.TimeDeserializer;
import com.ridecrew.springbootridecrew.serializer.TimeSerializer;
import com.ridecrew.springbootridecrew.serializer.TimestampDeserializer;
import com.ridecrew.springbootridecrew.serializer.TimestampSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	private LocalTime startTime;
	
	@NotNull
	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	private LocalTime endTime;
	
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
	
	@CreatedDate
	@JsonSerialize(using = TimestampSerializer.class)
	@JsonDeserialize(using = TimestampDeserializer.class)
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @JsonSerialize(using = TimestampSerializer.class)
	@JsonDeserialize(using = TimestampDeserializer.class)
    @Column(name = "last_modified_at", updatable = true)
    private LocalDateTime lastModifiedDateTime;
	
}
