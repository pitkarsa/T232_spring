package com.itvedant.productcrud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/hello")  // url "/hello", request type : GET
	public String sayHello() {
		return "Hello developer";
	}
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hi developer";
	}
	
	@GetMapping("")
	public String home() {
		return "Welcome to ProductCRUD";
	}
}
