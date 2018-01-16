package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridecrew.springbootridecrew.domain.GalleryPicture;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.GalleryPictureRepository;

@Service
@Transactional
public class GalleryPictureServiceImpl implements GalleryPictureService{

	@Autowired
	private GalleryPictureRepository repository;
	
	@Override
	public ApiResult<ArrayList<GalleryPicture>> findByGalleryId(Long galleryId) {
		return new ApiResult<>(repository.findByGalleryId(galleryId));
	}

	@Override
	public ApiResult<GalleryPicture> addPicture(GalleryPicture picture) {
		return new ApiResult<>(repository.save(picture));
	}

}
