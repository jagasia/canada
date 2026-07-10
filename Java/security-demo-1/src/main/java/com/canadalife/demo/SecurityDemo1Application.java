package com.canadalife.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
@RestController
public class SecurityDemo1Application {

	@GetMapping
	public String home() {
		return "Hello world";
	}
	
	@GetMapping("/about")
	public String about() {
		return "About us";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityDemo1Application.class, args);
	}

}
