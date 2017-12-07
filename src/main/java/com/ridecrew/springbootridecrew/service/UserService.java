package com.ridecrew.springbootridecrew.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ridecrew.springbootridecrew.domain.User;

public interface UserService {
	User findOne(Long id);

    List<User> getAllUsers();

    boolean create(User user);

    User update(User user);

    void delete(Long id);
    
    List<User> findByEmail(String email);
}
