package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridecrew.springbootridecrew.domain.Gallery;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.GalleryRepository;

@Service
@Transactional  // auto rollback if query fails 
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryRepository repository;

	@Override
	public ApiResult<ArrayList<Gallery>> getAll() {
		ArrayList<Gallery> lists = new ArrayList<>();
		repository.findAll().forEach(e-> lists.add(e));
		return new ApiResult<>(lists);
	}

	@Override
	public ApiResult<Gallery> addGallery(Gallery gallery) {
		return new ApiResult<>(repository.save(gallery));
	}

	@Override
	public ApiResult<Void> deleteGallery(Long id) {
		repository.delete(id);
		return new ApiResult<>();
	}
}
