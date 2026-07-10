package com.canadalife.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails u1=User.withUsername("anup")
				.password("{noop}anup@123")
				.authorities("ADMIN","USER")
				.build();

		
		return u1;
	}

	
}
