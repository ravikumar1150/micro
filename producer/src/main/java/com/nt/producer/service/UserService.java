package com.nt.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nt.producer.entity.Users;

@Service
public class UserService {
	
	private KafkaTemplate<String, Users> kafkaTemp;

	private static final String TOPIC = "user-topic";

	public UserService(KafkaTemplate<String, Users> kafkaTemp) {
		this.kafkaTemp = kafkaTemp;

	}
	
	public void sendUser(Users users ) {
		kafkaTemp.send(TOPIC,users);
		System.out.println("Users Send :"+users.getName());
		
	}

}
