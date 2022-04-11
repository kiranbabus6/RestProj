package com.in28mins.rest.webservices.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28mins.rest.webservices.exceptions.UserNotFoundException;

@Component("userDaoService")
public class UserDaoService {

	private List<User> userList;
	
	public List<User> findAll()
	{
		setUserList();
		return userList;
	}
	
	public User save(User user)
	{
		setUserList();
		if(user.getId()==null)
			user.setId(userList.stream().max(Comparator.comparing(User::getId)).get().getId()+1);		
		userList.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		setUserList();
		for(User user : userList)
		{
			if (user.getId()==id)
				return user;
		}
		throw new UserNotFoundException("id= "+id);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList() {
		if(userList==null)
		{
		userList = new ArrayList<>();
		userList.add(new User(1,"Kiran", new Date()));
		userList.add(new User(2,"Anand", new Date()));
		userList.add(new User(3,"Akki", new Date()));
		}

	}
/*	
	public static void main(String[] args)
	{
		List<User> u1 = new ArrayList<User>();
		u1.add(new User(1,"Kiran", new Date()));
		u1.add(new User(2,"Anand", new Date()));
		u1.add(new User(3,"Aks", new Date()));
		System.out.println(u1.stream().max(Comparator.comparing(User::getId)).get().getId());
	}
	*/
}
