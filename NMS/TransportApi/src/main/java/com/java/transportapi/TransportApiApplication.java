package com.java.transportapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TransportApiApplication {
	
	
	 private Map<String, String> transportResources = new HashMap<>(); 
	 
	 
	 @PostMapping("/resources") 
	   public String createResource(@RequestBody String resource) { 
	       String id = "res" + (transportResources.size() + 1); 
	       transportResources.put(id, resource); 
	       return "Resource created with ID: " + id; 
	   } 
	  
	   @GetMapping("/resources/{id}") 
	   public String getResource(@PathVariable String id) { 
	       return transportResources.getOrDefault(id, "Resource not found"); 
	   } 
	  
	   @PutMapping("/resources/{id}") 
	   public String updateResource(@PathVariable String id, @RequestBody String resource) { 
	       transportResources.put(id, resource); 
	       return "Resource updated"; 
	   } 
	  
	   @DeleteMapping("/resources/{id}") 
	   public String deleteResource(@PathVariable String id) { 
	       transportResources.remove(id); 
	       return "Resource deleted"; 
	   } 
	   
	public static void main(String[] args) {
		SpringApplication.run(TransportApiApplication.class, args);
	}

}
