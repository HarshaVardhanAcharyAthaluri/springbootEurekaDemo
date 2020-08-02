package com.kafkaproducer.producerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProducer {

	@Autowired
	KafkaTemplate<String, String> kafkatemplate;
	
	private static final String topic = "demotopic";
	
	@GetMapping("/produce/{msg}")
	public String producemsg(@PathVariable String msg){
		kafkatemplate.send(topic, msg);
		
		
		return "Message Produced";
	}
	
}
