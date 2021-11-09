package com.Lesson4EndProject.com.Lesson4EndProject.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	Greeting greeting;
	
	
	AtomicLong counter = new AtomicLong() ;
	
	// create a GET REST call http://localhost:8888/greeting?name=Sonal
	
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name")String name) {
		
		greeting.setId(counter.incrementAndGet());
		
		greeting.setContent("Hey I am Learing Lesson4 project from " + name);
		
		return greeting;
	}

}
