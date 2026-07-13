package com.canadalife.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.canadalife.demo.filter.JwtAuthenticationFilter;


@Configuration
public class MySecurityConfiguration {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

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
//	        .csrf(csrf -> csrf
//	                .ignoringRequestMatchers("/h2-console/**"))
	        
	        .csrf(csrf->csrf.disable())
	        
	        .headers(headers -> headers
	                .frameOptions(frame -> frame.sameOrigin()))
	        
	        .formLogin(form -> form.disable())
	        
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
//            .httpBasic(Customizer.withDefaults());
            
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
	 }
	 
	 @Bean
	 AuthenticationManager authenticationManager(
	         AuthenticationConfiguration configuration)
	         throws Exception {

	     return configuration.getAuthenticationManager();
	 }
	
}
