package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MailSendarUsingKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSendarUsingKafkaApplication.class, args);
	}

}
