package com.in28mins.rest.webservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.rest.webservices.beans.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping( path="/hello-world")
	public String helloWorld()
	{
		return "hello World, its my first";
	}
	
	
	@GetMapping( path="/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("hello World, its my first bean return");
	}

	@GetMapping(path="/hello-world-bean/path-variable/{pathName}")
	public HelloWorldBean helloWorldBeanPathVar(@PathVariable String pathName)
	{
		return new HelloWorldBean(String.format( pathName));
	}
}
