package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;

import com.ridecrew.springbootridecrew.domain.GalleryPicture;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface GalleryPictureService {
	ApiResult<ArrayList<GalleryPicture>> findByGalleryId(Long galleryId);
}
