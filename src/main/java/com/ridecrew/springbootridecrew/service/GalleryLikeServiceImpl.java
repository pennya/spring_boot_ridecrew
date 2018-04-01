package com.ridecrew.springbootridecrew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ridecrew.springbootridecrew.domain.GalleryLike;
import com.ridecrew.springbootridecrew.model.ApiErrorCode;
import com.ridecrew.springbootridecrew.model.ApiErrorType;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.GalleryLikeRepository;

@Service
@Transactional
public class GalleryLikeServiceImpl implements GalleryLikeService {
	
	@Autowired
	private GalleryLikeRepository repository;

	@Override
	public ApiResult<GalleryLike> add(GalleryLike gl) {
		GalleryLike preGalleryLike = 
				repository.findByGalleryIdAndMemberId(
						gl.getGallery().getId(),
						gl.getMember().getId());
		
		if(preGalleryLike != null) {
			return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_ID, "DUPLICATE LIKE ID");
		}
		
		return new ApiResult<>(repository.save(gl));
	}

	@Override
	public ApiResult<Void> delete(Long galleryId, Long memberId) {
		GalleryLike galleryLike = 
				repository.findByGalleryIdAndMemberId(galleryId, memberId);
		
		repository.delete(galleryLike);
		return new ApiResult<>();
	}

	@Override
	public ApiResult<List<GalleryLike>> findByGalleryIdLong(Long galleryId) {
		return new ApiResult<>(repository.findByGalleryId(galleryId));
	}

}
