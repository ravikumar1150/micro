 package com.nt.producer.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.nt.producer.consumer.Users;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, Users> userConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", ErrorHandlingDeserializer.class.getName());
        props.put("spring.deserialization.trusted.packages", "com.nt.producer.consumer");
        props.put("spring.json.trusted.packages", "com.nt.producer.consumer");
        props.put("spring.json.value.default.type", "com.nt.producer.consumer.Users");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), 
                new JsonDeserializer<>(Users.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Users> userKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Users> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }
}
