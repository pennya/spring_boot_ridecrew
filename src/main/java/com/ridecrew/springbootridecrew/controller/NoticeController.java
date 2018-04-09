package com.ridecrew.springbootridecrew.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Notice;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.repository.NoticeRepository;

@RestController // @Controller + @ResponseBody
public class NoticeController {
	
	/**
	 * RestController - Repository - Domain
	 * without service( business logic)
	 */

	@Autowired
	private NoticeRepository repository; 
	
	@GetMapping("/rest/v1/notice")
	public ApiResult<ArrayList<Notice>> getAllNotice() {
		try {
			ArrayList<Notice> lists = new ArrayList<>();
			for(Notice notice : repository.findAll()) {
				lists.add(notice);
			}
			return new ApiResult<>(lists);
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@PostMapping("/rest/v1/notice")
	public ApiResult<Notice> addNotice(@RequestBody Notice notice) {
		try {
			return new ApiResult<>(repository.save(notice));
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@DeleteMapping("/rest/v1/notice/{id}")
	public ApiResult<Void> deleteNotice(@PathVariable("id") Long id) {
		try {
			repository.delete(id);
			return new ApiResult<>();
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@PatchMapping("rest/v1/notice/{id}")
	public ApiResult<Notice> patchNotice(@PathVariable("id") Long id, @RequestBody Notice notice) {
		try {
			Notice origin = repository.findOne(id);
			origin.setType(notice.getType());
			origin.setTitle(notice.getTitle());
			origin.setContent(notice.getContent());
			origin.setImageUrl(notice.getImageUrl());
			origin.setWebUrl(notice.getWebUrl());
			
			return new ApiResult<>(repository.save(origin));
		} catch( RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}

