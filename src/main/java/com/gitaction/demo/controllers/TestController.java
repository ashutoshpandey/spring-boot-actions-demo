package com.gitaction.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitaction.demo.pojo.HelloData;

@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String sayHello() {
		logger.trace("Log level: TRACE");
		return "hello";
	}

	@RequestMapping("/bye")
	public String sayBye() {
		logger.info("Log level: INFO");
		return "bye";
	}

	@PostMapping("/bye-to-name")
	public String sayByeToName(@RequestBody HelloData data) {
		logger.error("Log level: DEBUG");
		return "Bye " + data.getName();
	}
}
