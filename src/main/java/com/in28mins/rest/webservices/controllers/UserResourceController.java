package com.in28mins.rest.webservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.rest.webservices.vo.User;
import com.in28mins.rest.webservices.vo.UserDaoService;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	@GetMapping("users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user)
	{
		return service.save(user);
	}
	

}
