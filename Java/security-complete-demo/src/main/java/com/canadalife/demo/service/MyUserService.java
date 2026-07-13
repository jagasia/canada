package com.canadalife.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.MyUser;
import com.canadalife.demo.repository.MyUserRepository;

@Service
public class MyUserService {
	private final MyUserRepository repo;
	@Autowired
	private PasswordEncoder pe;

	MyUserService(MyUserRepository repo) {
		this.repo = repo;
	}
	
	public MyUser signup(MyUser user) {
		user.setPassword(pe.encode(user.getPassword()));
		return repo.save(user);
	}
	
	public List<MyUser> getUsersList() {
		return repo.findAll();
	}
	
	public MyUser login(String username) {
		return repo.findByUsername(username);
	}
	
	//update , delete are optional
}
