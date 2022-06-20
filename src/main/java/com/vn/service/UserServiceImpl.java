package com.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vn.entities.Users;
import com.vn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Users register(Users users) {
		
		// encode password
		String rawPassword = users.getPassword();
		String hashPassword = passwordEncoder.encode(rawPassword);
		
		//users.setUsername(hashPassword);
		users.setPassword(hashPassword);
		
		userRepository.save(users);
		return users;
	}

}
