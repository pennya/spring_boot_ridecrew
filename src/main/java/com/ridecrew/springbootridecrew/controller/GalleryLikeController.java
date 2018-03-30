package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.GalleryLike;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.GalleryLikeService;

@RestController
public class GalleryLikeController {

	@Autowired
	private GalleryLikeService service;
	
	@RequestMapping(value = "/rest/v1/galleryLike", method = RequestMethod.POST)
	public ApiResult<GalleryLike> add(@RequestBody GalleryLike gl) {
		try {
			return service.add(gl);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/galleryLike", method = RequestMethod.DELETE)
	public ApiResult<Void> delete(@RequestParam("galleryId") Long galleryId, 
								@RequestParam("memberId") Long memberId ) {
		
		try {
			return service.delete(galleryId, memberId);
		} catch ( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "rest/v1/galleryLike_by_galleryId", method = RequestMethod.GET)
	public ApiResult<List<GalleryLike>> getAllByScheduleId(@RequestParam("galleryId") Long galleryId) {
		try {
			return service.findByGalleryIdLong(galleryId);
		} catch ( RuntimeException e ) {
			return new ApiResult<>(e);
		}
	}
}
