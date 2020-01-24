package com.springComplete.project.restfulwebservice.helloworld;

 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleContextResolver;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping( path="/hello-world")
	public String  returnHello() {
		return "hello World";
		
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean  returnHelloBean() {
		return new HelloWorldBean("hello-World-Bean");
		
	}
	
	@GetMapping(path="/hello-world-bean/path-varivale/{name}")
	public HelloWorldBean  returnHelloPathVarible(@PathVariable String name ) {
		return new HelloWorldBean(String.format("hello-World, %S", name));
		
	}
	
	@GetMapping( path="/hello-world-international")
	public String  returnGoodMorning() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
		
	}
	
	
}
