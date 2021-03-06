package com.springComplete.project.restfulwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localerRsolver() {
		AcceptHeaderLocaleResolver headerocaleResolver = new AcceptHeaderLocaleResolver();
		headerocaleResolver.setDefaultLocale(Locale.US);
		return headerocaleResolver;
		
	}
	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		 ResourceBundleMessageSource messageSource=	new ResourceBundleMessageSource();
		messageSource.setBasename("messages");		
		return messageSource;
		
	}*/
	

}
