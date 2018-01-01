package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/rest/v1/members", method = RequestMethod.POST)
	public ApiResult<Member> add(@RequestBody Member command) {
		try {
			return memberService.create(command);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/members/{id}", method = RequestMethod.GET)
	public ApiResult<Member> find(@PathVariable("id") Long id) {
		try {
			return memberService.findOne(id);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "/rest/v1/members/{id}", method = RequestMethod.PUT)
	public ApiResult<Member> update(@PathVariable("id") Long id, @RequestBody Member member) {
		try {
			return memberService.update(id, member);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/members", method = RequestMethod.GET)
	public ApiResult<List<Member>> getmembers() {
		try {
			return memberService.getAllMembers();
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/members/{id}", method = RequestMethod.DELETE)
	public ApiResult<Void> delete(@PathVariable("id") Long id) {
		try {
			return memberService.delete(id);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/memberbyemail", method = RequestMethod.GET)
	public ApiResult<Member> findByEmail(@RequestParam(value = "email") String email) {
		try {
			return memberService.findByEmail(email);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
	@RequestMapping(value = "rest/v1/member_login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ApiResult<Member> findByEmailAndPwd(String email, String pwd) {
		try {
			return memberService.findByEmailAndPwd(email, pwd);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
	
}
