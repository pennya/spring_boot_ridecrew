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

@Entity(name="gallery_picture")
@Getter
@Setter
@ToString
public class GalleryPicture implements Serializable{
	
	private static final long serialVersionUID = 1148865188165946272L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gallery_picture_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="gallery_id")
	private Gallery gallery;
	
	@Column(nullable=false)
	private String imageUrl;
	
	@Column
	private int sort;
}
