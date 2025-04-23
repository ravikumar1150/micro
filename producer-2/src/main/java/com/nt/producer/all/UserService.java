package com.nt.producer.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private KafkaEmp kafkaEmp;
	
	public void getAllEmp() {
		
		Iterable<Users> all = empRepo.findAll();
		
		all.forEach(users ->kafkaEmp.sendUser(users));
		
	}
	
	
}
