package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.MemberService;

@RestController
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/rest/v1/members", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Member command) {
		try {
			boolean flag = memberService.create(command);
			if (!flag) {
				return new ResponseEntity<String>("conflict", HttpStatus.CONFLICT);
			}
			return new ResponseEntity<String>("created", HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("bad_request", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/rest/v1/members/{id}", method = RequestMethod.GET)
	public ApiResult<Member> find(@PathVariable("id") Long id) {
		try {
			Member member = memberService.findOne(id);
			return new ApiResult<>(member);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/members", method = RequestMethod.GET)
	public ApiResult<List<Member>> getmembers() {
		try {
			List<Member> members = memberService.getAllMembers();
			return new ApiResult<>(members);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/members/{id}", method = RequestMethod.DELETE)
	public ApiResult delete(@PathVariable("id") Long id) {
		try {
			memberService.delete(id);
			return new ApiResult();
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/memberbyemail", method = RequestMethod.GET)
	public ApiResult<List<Member>> findByEmail(@RequestParam(value = "email") String email) {
		try {
			List<Member> members = memberService.findByEmail(email);
			return new ApiResult<>(members);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}
