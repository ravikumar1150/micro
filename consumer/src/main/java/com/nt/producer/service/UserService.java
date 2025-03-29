package com.nt.producer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nt.producer.consumer.Users;

@Service
public class UserService {
	
	    
	    @KafkaListener(topics = "user-topic", groupId = "user-group", 
	                   containerFactory = "userKafkaListenerFactory")
	    public void consumeUser(Users users) {
	        System.out.println("User Received: " + users.getName()+"mail"+users.getEmail());
	    }

}
