package com.ridecrew.springbootridecrew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridecrew.springbootridecrew.domain.Member;
import com.ridecrew.springbootridecrew.exception.DuplicateLoginIdException;
import com.ridecrew.springbootridecrew.model.ApiErrorCode;
import com.ridecrew.springbootridecrew.model.ApiErrorType;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/rest/v1/members", method = RequestMethod.POST)
	public ApiResult<Member> add(@RequestBody Member command) {
		try {
			ApiResult<Member> result = memberService.create(command);
			return result;
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		} catch (DuplicateLoginIdException e) {
			return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_LOGIN_ID, "");
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
	public<T> ApiResult<T> delete(@PathVariable("id") Long id) {
		try {
			memberService.delete(id);
			return new ApiResult<>();
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}

	@RequestMapping(value = "/rest/v1/memberbyemail", method = RequestMethod.GET)
	public ApiResult<Member> findByEmail(@RequestParam(value = "email") String email) {
		try {
			Member member = memberService.findByEmail(email);
			return new ApiResult<>(member);
		} catch (RuntimeException e) {
			return new ApiResult<>(e);
		}
	}
}
