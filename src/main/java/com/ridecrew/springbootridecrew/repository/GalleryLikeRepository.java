package com.ridecrew.springbootridecrew.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.GalleryLike;

@Repository
public interface GalleryLikeRepository extends JpaRepository<GalleryLike, Long>{
	ArrayList<GalleryLike> findByGalleryId(Long galleryId);
	GalleryLike findByGalleryIdAndMemberId(Long galleryId, Long memberId);
}
