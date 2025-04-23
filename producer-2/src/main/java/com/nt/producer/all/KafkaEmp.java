package com.nt.producer.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEmp {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "emp-topic";

    public void sendUser(Users users) {
        kafkaTemplate.send(TOPIC, users);
        System.out.println("Producer Sent Employee Details: " + users.getName() 
                            + " " + users.getEmail() + " " + users.getJobRoll());
    }

    @KafkaListener(topics = "scu-topic", groupId = "producer-group")
    public void receivedMsg(String successMessage) {
        System.out.println("Acknowledgment from Consumer: " + successMessage);
    }
}
