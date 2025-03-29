package com.nt.producer.userController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.producer.userService.UserServices1;

@RestController
@RequestMapping("user")
public class UserController {

	private UserServices1 userService;

	public UserController(UserServices1 userService) {
		this.userService = userService;

	}

	@GetMapping("/getUser")
	public String getUsers() {

		userService.findAllUser();
		return "User-SendTOKafka ! From Producer";

	}

}
