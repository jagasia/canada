package com.canadalife.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.MyUser;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private MyUserService us;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser myUser = us.login(username);
		if(myUser==null)
			throw new UsernameNotFoundException("Login failed");
		
		String csv=myUser.getAuthorities();		//it is a csv authorities
		String[] arr = csv.split(",");
		List<GrantedAuthority> authorities=new ArrayList<>();
		for(String authority:arr) {
			SimpleGrantedAuthority a=new SimpleGrantedAuthority(authority);
			authorities.add(a);
		}
		
		User user=new User(username, myUser.getPassword(), authorities);

		return user;
		
	}

}
