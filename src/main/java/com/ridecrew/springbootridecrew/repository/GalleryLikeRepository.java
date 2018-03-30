package com.ridecrew.springbootridecrew.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridecrew.springbootridecrew.domain.GalleryLike;

public interface GalleryLikeRepository extends JpaRepository<GalleryLike, Long>{
	ArrayList<GalleryLike> findByGalleryId(Long galleryId);
	GalleryLike findByGalleryIdAndMemberId(Long galleryId, Long memberId);
}
