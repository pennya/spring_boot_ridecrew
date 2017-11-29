package com.ridecrew.springbootridecrew.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ridecrew.springbootridecrew.domain.User;
import com.ridecrew.springbootridecrew.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> getAllUsers() {
		return Lists.newArrayList(userRepository.findAll());
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return user;
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
