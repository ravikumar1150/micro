package com.nt.producer.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class EmpController {
	
	@Autowired
	private UserService userService;
	
	
     @GetMapping("/getEmp")
	public ResponseEntity<String> getEmployee(){
		
		userService.getAllEmp();
		
		return new ResponseEntity<>("Employee Send Success fully :",HttpStatus.OK);
		
	}
	
}
