package com.canadalife.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails u1=User.withUsername("anup")
				.password("{noop}anup@123")
				.authorities("ADMIN","USER")
				.build();
		
		UserDetails u2=User.withUsername("bhuvan")
				.password("{noop}bhuvan@123")
				.authorities("USER")
				.build();
		
		UserDetails u3=User.withUsername("reza")
				.password("{noop}reza@123")
				.authorities("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(u1, u2, u3);
		
	}
	
}
