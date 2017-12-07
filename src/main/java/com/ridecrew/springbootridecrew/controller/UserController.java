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

import com.ridecrew.springbootridecrew.domain.User;
import com.ridecrew.springbootridecrew.model.ApiResult;
import com.ridecrew.springbootridecrew.service.UserService;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

    @RequestMapping(value = "/rest/v1/users", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody User command) {
        try {
        	boolean flag = userService.create(command);
        	if(!flag) {
        		return new ResponseEntity<String>("conflict", HttpStatus.CONFLICT);
        	}
        	return new ResponseEntity<String>("created", HttpStatus.CREATED);
        }catch(RuntimeException e) {
            return new ResponseEntity<String>("bad_request", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/rest/v1/users/{id}", method = RequestMethod.GET)
    public ApiResult<User> find(@PathVariable("id")Long id) {
        try {
            User user =  userService.findOne(id);
            return new ApiResult<>(user);
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    @RequestMapping(value = "/rest/v1/users", method = RequestMethod.GET)
    public ApiResult<List<User>> getUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ApiResult<>(users);
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    @RequestMapping(value = "/rest/v1/users/{id}", method = RequestMethod.DELETE)
    public ApiResult delete(@PathVariable("id")Long id) {
        try {
            userService.delete(id);
            return new ApiResult();
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }
    
    @RequestMapping(value = "/rest/v1/userbyemail", method = RequestMethod.GET)
    public ApiResult<List<User>> findByEmail(@RequestParam(value = "email") String email) {
    	try {
    		List<User> users = userService.findByEmail(email);
    		return new ApiResult<>(users);
    	} catch(RuntimeException e) {
    		return new ApiResult<>(e);
    	}
    }
}
