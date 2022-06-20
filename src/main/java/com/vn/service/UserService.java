package com.vn.service;

import java.util.List;

import com.vn.entities.Users;

public interface UserService {
	
	public Users register(Users users);
	
	public List<Users> listAll();

	public Users saveUsers(Users e);

	public void delete(Integer id);

	public Users get(Integer id);
	
	public Users checkUsername(String username);
	
    
	public Users checkEmail(String email);

	Users update(Users employee);
	
	List<Users> findAll();
	
	//find all employee / member /admin
	List<Users> findAllByRole(String role);

	public Users findById(Integer id);
	
}
