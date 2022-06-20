package com.vn.service.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.entities.Role;
import com.vn.entities.Users;
import com.vn.repository.RoleRepository;
import com.vn.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found ..");
		}
		
		// map - intermediate operator
		// collect - terminal operator
		List<Integer> idRoles = user.getUserRoles().stream().map(x -> {
			return x.getRole().getId();
		}).collect(Collectors.toList());
		
		//find role
		List<Role> roles = roleRepository.findAllById(idRoles);
		
		return new CustomUserDetail(user, roles);
	}

}
