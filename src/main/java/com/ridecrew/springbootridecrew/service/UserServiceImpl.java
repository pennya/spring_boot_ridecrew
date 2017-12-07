package com.ridecrew.springbootridecrew.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public synchronized boolean create(User user) {
		List<User> list = userRepository.findByEmail(user.getEmail());
		if(list.size() > 0) {
			return false;
		} else {
			userRepository.save(user);
			return true;
		}
	}

	@Override
	public User update(User user) {
		return user;
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
