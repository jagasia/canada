package com.canadalife.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.canadalife.demo.service.MyUserDetailsService;

@RestController
@RequestMapping("/api/v1/user/")
public class MyUserController {
	@Autowired
	private MyUserDetailsService us;
	
	@Autowired
	private AuthenticationManager am;
	
	@Autowired
	private JwtService jwtService;
	
	private static final Logger logger =
            LoggerFactory.getLogger(MyUserController.class);	

	@PostMapping("/signup")
	public MyUser signup(@RequestBody MyUser user) {
		logger.info(user.toString());
		return us.create(user);
	}
	
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest authRequest) {
		Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		AuthResponse response=null;
		if(auth.isAuthenticated()) {
			//give jwt
			
		UserDetails userDetails=	(UserDetails) auth.getPrincipal();
		String token = jwtService.generateToken(userDetails);
		
		response=new AuthResponse(token);
			
		}else {
			throw new UsernameNotFoundException("Login failed");
		}
		
		return response;
	}
	
}
