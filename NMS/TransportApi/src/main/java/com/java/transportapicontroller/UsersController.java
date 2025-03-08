package com.java.transportapicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.transportapi.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UsersController {
	
	@Autowired 
	private IUserService service; 
	
	
	@ResponseStatus(HttpStatus.FOUND) 
	@GetMapping("/getall") 
	public Flux<Users> getAllUsers() { 
	return service.getAllUsers(); 
	} 
	@GetMapping("/getbyid/{id}") 
	public Mono<Users> getUserById(@PathVariable Long id) { 
	return service.getUserById(id); 
	} 
	@PostMapping("/create") 
	@ResponseStatus(HttpStatus.CREATED) 
	public Mono<Object> createUser(@RequestBody Users users) { 
	return service.createUser(user); 
	} 
	@PutMapping("/update/{id}") 
	public Mono<Users> updateUser(@PathVariable long id, @RequestBody Users users) { 
	return service.updateUser(id, users); 
	} 
	@GetMapping("/name/{name}") 
	public Flux<Users> getUsersByName(@PathVariable String name) { 
	return service.getUsersByName(name); 
	} 
	@DeleteMapping("/delete/{id}") 
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public Mono<Void> deleteUser(@PathVariable Long id) { 
	return service.deleteUs(id); 
	} 

}
