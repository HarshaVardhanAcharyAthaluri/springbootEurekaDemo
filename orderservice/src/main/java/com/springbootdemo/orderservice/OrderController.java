package com.springbootdemo.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/orderhello")
	public String getUser() {
		String url = "http://USERSERVICE/hello";
		
		return restTemplate.getForObject(url, String.class);
	}

}
