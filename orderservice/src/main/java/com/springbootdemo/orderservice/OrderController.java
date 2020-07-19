package com.springbootdemo.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/orderhello")
	@HystrixCommand(fallbackMethod = "getuserfallback",commandKey = "getuser")
	public String getUser() {
		String url = "http://USERSERVICE/hello";
		
		return restTemplate.getForObject(url, String.class);
	}

	@GetMapping("/hello")
	public String helloorder() {
		return "Hello from OrderService";
	}
	
	public String getuserfallback() {
	return "Fallback happened for GetUser";
	}
}
