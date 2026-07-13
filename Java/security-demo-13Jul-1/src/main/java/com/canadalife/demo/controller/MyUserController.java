package com.canadalife.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canadalife.demo.entity.MyUser;
import com.canadalife.demo.service.MyUserDetailsService;

@RestController
@RequestMapping("/api/v1/user")
public class MyUserController {
	@Autowired
	private MyUserDetailsService us;
	
	@GetMapping("/signup/{username}/{password}")
	public MyUser signup(@PathVariable String username, @PathVariable String password) {
		MyUser user=new MyUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setAuthorities("");
		return us.create(user);
	}
}
