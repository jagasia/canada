package com.canadalife.demo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.MyUser;
import com.canadalife.demo.repository.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	private MyUserRepository ur;
	
	private PasswordEncoder pe;

	
	public MyUserDetailsService(MyUserRepository ur, PasswordEncoder pe) {
		super();
		this.ur = ur;
		this.pe = pe;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> temp = ur.findById(username);
		if(temp.isEmpty()) {
			throw new UsernameNotFoundException("Login failed");
		}
		MyUser user = temp.get();
		
		return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRoles().split(","))
				.build();
		
	}
	
	//adding a new user (signup)
	public MyUser create(MyUser user) {		
		user.setPassword(pe.encode(user.getPassword()));
		return ur.save(user);
	}
	
	

	
}
