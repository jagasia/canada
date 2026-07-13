package com.canadalife.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class MySecurityConfiguration {

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http
	        .csrf(csrf -> csrf
	                .ignoringRequestMatchers("/h2-console/**"))
	        
	        .headers(headers -> headers
	                .frameOptions(frame -> frame.sameOrigin()))
	     // Authorization rules
            .authorizeHttpRequests(auth -> auth

                // Public endpoints
                .requestMatchers(
                        "/api/v1/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/h2-console/**")
                .permitAll()
              

                // Everything else
                .anyRequest().authenticated())

            // Authentication mechanism
            .httpBasic(Customizer.withDefaults());

        return http.build();
	 }
	
}
