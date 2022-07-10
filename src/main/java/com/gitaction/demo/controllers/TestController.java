package com.gitaction.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitaction.demo.pojo.HelloData;

@RestController
public class TestController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@RequestMapping("/bye")
	public String sayBye() {
		return "bye";
	}

	@PostMapping("/bye-to-name")
	public String sayByeToName(@RequestBody HelloData data) {
		return "Bye " + data.getName();
	}
}
