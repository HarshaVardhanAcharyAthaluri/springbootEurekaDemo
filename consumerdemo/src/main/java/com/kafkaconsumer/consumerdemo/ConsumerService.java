package com.kafkaconsumer.consumerdemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	@KafkaListener(topics = "demotopic",groupId = "group_id")
	public void consumemsg(String message) {
		System.out.println("consumed message: "+ message);
	}

}
