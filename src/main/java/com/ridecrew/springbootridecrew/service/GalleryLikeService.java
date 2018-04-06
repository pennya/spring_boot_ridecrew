package com.ridecrew.springbootridecrew.service;

import java.util.List;

import com.ridecrew.springbootridecrew.domain.GalleryLike;
import com.ridecrew.springbootridecrew.model.ApiResult;

public interface GalleryLikeService {
	ApiResult<GalleryLike> add(GalleryLike gl);

	ApiResult<Void> delete(Long galleryId, Long memberId);

	ApiResult<List<GalleryLike>> findByGalleryIdLong(Long galleryId);
}