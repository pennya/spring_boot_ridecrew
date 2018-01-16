package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;

import com.ridecrew.springbootridecrew.domain.Gallery;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface GalleryService{
	ApiResult<ArrayList<Gallery>> getAll();
	ApiResult<Gallery> addGallery(Gallery gallery);
	ApiResult<Void> deleteGallery(Long id);
}
