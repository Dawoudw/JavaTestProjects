package com.example.demo;

import java.lang.reflect.Method;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public String sayHello() {
		return "Say Helloooo...";
		// TODO Auto-generated constructor stub
	}

}
