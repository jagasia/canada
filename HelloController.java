package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MessageService messageService;

    // TODO: Create an endpoint here that handles GET requests to "/hello"
    // TODO: This method should call messageService.getWelcomeMessage() and return its result.
	//this is typed by jag
    @GetMapping("/hello")
    public String hello() {
        //Jag typed this for testing purpose
        return messageService.getWelcomeMessage();
    }
}