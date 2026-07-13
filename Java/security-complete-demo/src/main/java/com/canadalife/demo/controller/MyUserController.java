package com.canadalife.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canadalife.demo.entity.MyUser;
import com.canadalife.demo.helper.AuthRequest;
import com.canadalife.demo.helper.AuthResponse;
import com.canadalife.demo.service.JwtService;
import com.canadalife.demo.service.MyUserService;

@RestController
@RequestMapping("/api/v1/user")
public class MyUserController {
	@Autowired
	private MyUserService mus;
	
	@Autowired
	private AuthenticationManager am;
	
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping("/signup")
	public MyUser signup(@RequestBody MyUser user) {
		return mus.signup(user);
	}
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest authRequest) {
		Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		AuthResponse response=null;
		if(auth.isAuthenticated()) {
			//return jwt
			UserDetails userDetails=(UserDetails) auth.getPrincipal();
			String token = jwtService.generateToken(userDetails);
			response=new AuthResponse(token, userDetails.getUsername(), userDetails.getAuthorities());
		}else {
			throw new UsernameNotFoundException("Login failed");
		}
		return response;
	}
}
