package com.vn.service;

import java.util.List;
import java.util.Optional;

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

		// users.setUsername(hashPassword);
		users.setPassword(hashPassword);

		userRepository.save(users);
		return users;
	}

	@Override
	public List<Users> listAll() {
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public Users saveUsers(Users e) {

		return userRepository.save(e);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public Users get(Integer id) {
		Optional<Users> employee = userRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Users checkUsername(String username) {
		return userRepository.findByUsername(username);

	}

	@Override
	public Users checkEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Users update(Users employee) {
		userRepository.save(employee);
		return employee;
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<Users> findAllByRole(String role) {
		return userRepository.findAllByRole(role);
	}

	@Override
	public Users findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

}
