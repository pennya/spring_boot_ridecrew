package com.ridecrew.springbootridecrew.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.GalleryLike;

@Repository
public interface GalleryLikeRepository extends CrudRepository<GalleryLike, Long>{
	ArrayList<GalleryLike> findByGalleryId(Long galleryId);
	GalleryLike findByGalleryIdAndMemberId(Long galleryId, Long memberId);
}
