package com.springComplete.project.restfulwebservice.user;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;




@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userdaoService;
	
	@Autowired
	UserRepository userRepository;
	
		
	@GetMapping(path="/users")
	public  List<User> retrieveAllUsers() {	
		
		
		
		
		return userdaoService.findAll();
		
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user= userdaoService.findOne(id);
		if (user==null) {
			
			throw new UserNotFoundexception("Id-" +id);
		}	
		
		Resource<User> resource = new Resource<User>(user);		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));	
		
		
	
		
		return resource ;
	}
	
	@PostMapping(path ="/users")
	public ResponseEntity createUser (@Valid @RequestBody User user) {			
		User savedUser =userdaoService.Save(user);
	  URI location=	ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user= userdaoService.deleteById(id);
		if (user==null) {			
			throw new UserNotFoundexception("Id-" +id);
		}				
		
	}
	

}
