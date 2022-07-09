package com.gitaction.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
