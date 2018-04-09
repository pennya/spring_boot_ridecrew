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

@Entity(name="gallery_like")
@Getter
@Setter
@ToString
public class GalleryLike implements Serializable{
	
	private static final long serialVersionUID = -2975811493751267183L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gallery_like_id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="member_id")
	private Member member;
	
	@ManyToOne()
	@JoinColumn(name="gallery_id")
	private Gallery gallery;
	
}
