package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.Customer;
import com.nt.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;
   
	@PostMapping("/save")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws Exception {

		CustomerService.customerSave(customer);

		
		return ResponseEntity.ok(HttpStatus.CREATED);

	}

}
