package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.AuthRequest;
import com.nt.service.JwtService;

@RestController
@RequestMapping("api")
public class AuthController {

	@Autowired
	private JwtService jwtService;

	@PostMapping("/auth/login")
	public ResponseEntity<String> userCheck(@RequestBody AuthRequest authRequest) {
		System.out.println("AuthController.userCheck()");
		
	    if ("ravi".equals(authRequest.getUsername()) && "Ravi@1150".equals(authRequest.getPassword())) {
	        String token = jwtService.generateToken(authRequest.getUsername());
	        return ResponseEntity.ok(token);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
	    }
	}


	@GetMapping("/test/public")
	public String publicApi() {

		return "This Is Public Api";
	}
    
	@GetMapping("/test/private")
	public String privateApi() {

		return "private Api Calld ";
	}

}
