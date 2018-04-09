package com.ridecrew.springbootridecrew.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ridecrew.springbootridecrew.serializer.TimestampDeserializer;
import com.ridecrew.springbootridecrew.serializer.TimestampSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="gallery")
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Gallery implements Serializable{
	private static final long serialVersionUID = 8818165250721164347L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="gallery_id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToMany(mappedBy="gallery", orphanRemoval=true)
	@JsonIgnore
	private Set<GalleryPicture> galleryPictures;
	
	@OneToMany(mappedBy="gallery", orphanRemoval=true)
	@JsonIgnore
	private Set<GalleryLike> galleryLikes;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column(nullable=true)
	private String imageUrl;
	
	@Column
	private int likeCount;
	
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
