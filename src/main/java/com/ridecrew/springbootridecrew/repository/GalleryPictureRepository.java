package com.ridecrew.springbootridecrew.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ridecrew.springbootridecrew.domain.GalleryPicture;

@Repository
public interface GalleryPictureRepository extends JpaRepository<GalleryPicture, Long>{
	ArrayList<GalleryPicture> findByGalleryId(Long galleryId);
}
