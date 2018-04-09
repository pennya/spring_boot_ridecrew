package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ridecrew.springbootridecrew.serializer.TimestampDeserializer;
import com.ridecrew.springbootridecrew.serializer.TimestampSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "notice")
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Notice implements Serializable{
	private static final long serialVersionUID = -3156985599924900318L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notice_id")
	private Long id;
	
	@Column(nullable = false)
	private int type;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column
	private String imageUrl;
	
	@Column
	private String webUrl;
	
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
