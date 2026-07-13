package com.canadalife.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
//		UserDetails u1=User.withUsername("anup")
//				.password("$2a$12$3uYI4QhvYBEsx9RTZcsnWux0SdG0ldYymfFNZ91xSiCYHulDrJ/sC")
//				.authorities("ADMIN","USER")
//				.build();

		
//		return u1;
		Optional<MyUser> temp = ur.findById(username);
		if(temp.isEmpty()) {
			throw new UsernameNotFoundException("Login failed");
		}
		MyUser user = temp.get();
		
		return User.withUsername(username)
				.password(user.getPassword())
				.authorities(new ArrayList<>())
				.build();
		
	}
	
	//adding a new user (signup)
	public MyUser create(MyUser user) {
		//user sends plain password. it is our duty to encrypt and store in db
//		String plain=user.getPassword();
//		String encodedText=pe.encode(plain);
//		user.setPassword(encodedText);
//		ur.save(user);		
		
		user.setPassword(pe.encode(user.getPassword()));
		
		return ur.save(user);
	}
	
	

	
}
