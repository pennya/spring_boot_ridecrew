package com.ridecrew.springbootridecrew.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.GalleryPicture;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.GalleryPictureService;

@RestController
public class GalleryPictureController {

	@Autowired
	private GalleryPictureService service;
	
	@GetMapping("/rest/v1/gallery_picture")
	public ApiResult<ArrayList<GalleryPicture>> findByGalleryId(@RequestParam("galleryId") Long galleryId) {
		try {
			return service.findByGalleryId(galleryId);
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@PostMapping("/rest/v1/gallery_picture")
	public ApiResult<GalleryPicture> addPicture(@RequestBody GalleryPicture picture) {
		try {
			return service.addPicture(picture);
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}
