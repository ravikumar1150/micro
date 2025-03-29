package com.nt.producer.userService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.producer.entity.Users;
import com.nt.producer.repocitory.UserRepo;
import com.nt.producer.service.UserService;

@Service
public class UserServices1 {

	private UserRepo userRepo;
	private UserService userService;

	public UserServices1(UserRepo userRepo, UserService userService) {
		this.userRepo = userRepo;
		this.userService = userService;

	}
	
	public void findAllUser() {
		
		List<Users> users = userRepo.findAll();
		
		users.forEach(userService :: sendUser );
		
	}
	
	
}
