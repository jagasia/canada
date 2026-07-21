package com.canadalife.demo.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class TestConfig {

    @Bean
    CommandLineRunner test(Environment env) {
        return args -> {
            System.out.println("URI = " + env.getProperty("spring.data.mongodb.uri"));
        };
    }
}