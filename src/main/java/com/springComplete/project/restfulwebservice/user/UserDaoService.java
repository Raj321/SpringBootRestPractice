package com.springComplete.project.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int usercount=13;
	static {
		 users.add(new User(10, "Rajesh", new Date()));
		 users.add(new User(11, "upadhyay", new Date()));
		 users.add(new User(12, "raj", new Date()));
		 users.add(new User(13, "upadhyay2", new Date()));
		
	}
	
	public List<User> findAll() {		
		return users;		
	}
	
	public User Save(User user) {
		if (user.getId()==null) {
			user.setId(++usercount);
		}
		users.add(user);		
		return user;		
	}
	
	 public User findOne(int id ) {
		 for(User user:users) {
			 if(user.getId()==id) {
				 return user;
			 }	
			
		 }
		 return null; 
		 
	 }
	 public User deleteById(int id ) {
		 
		 Iterator<User> iterator = users.iterator();
		 while (iterator.hasNext())
		 {
			 User user = iterator.next();		 
			 if(user.getId()==id) {
				 iterator.remove();
				 return user;
			 }	
			
		 }
		 return null; 
		 
	 }
	 
	 
  
}
