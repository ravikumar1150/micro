package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.user.User;

public interface UserService {

	public User saveUser(User user);

	public Optional<User> getUserById(Integer id);

	public List<User> getAllUser();
	
	public List<Object[]> getUserNameEmail(String name);
	
	public Integer deleteUSer(Integer id);
	
	public Integer updateUSerName(String newName,String oldName,Integer id);
}
