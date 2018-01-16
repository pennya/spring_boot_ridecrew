package com.ridecrew.springbootridecrew.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Gallery;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.GalleryService;

@RestController
public class GalleryController {
	
	@Autowired
	private GalleryService service;

	@GetMapping("/rest/v1/gallery")
	public ApiResult<ArrayList<Gallery>> getAll() {
		try {
			return service.getAll();
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@PostMapping("/rest/v1/gallery")
	public ApiResult<Gallery> addGallery(@RequestBody Gallery gallery) {
		try {
			return service.addGallery(gallery);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@DeleteMapping("/rest/v1/gallery/{id}")
	public ApiResult<Void> deleteGallery(@PathVariable("id") Long id) {
		try {
			return service.deleteGallery(id);
		} catch(RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}
