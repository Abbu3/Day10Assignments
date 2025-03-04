package com.hexaware.springoauth2.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

		@GetMapping("/")
		public String  sayHello() {
			
			
			return  "Hello Friends , Welcome back";
			
		}
		
		
		@GetMapping("/secure")
		 @PreAuthorize("hasAuthority('admin')")
		public String  secureResource() {
			
			return "This is secured resource , access using app login / github credentials";
			
		}
	
	
}
