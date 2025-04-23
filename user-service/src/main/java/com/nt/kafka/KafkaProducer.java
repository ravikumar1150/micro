package com.nt.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String,Object> kafkTemplate;
	
	private static final String TOPIC="save-entity";
			
	public void sendTopic(String str) {
		kafkTemplate.send(TOPIC,str);
		System.out.println("message send Successfully....");
	
		
	}

}
