package com.wipro.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.security.entity.UserEntity;
import com.wipro.spring.security.service.IUserEntityService;

@RestController
@RequestMapping("/api/userEntity")
public class UserEntityController {
	
	@Autowired
	IUserEntityService iUserEntityService;
	
	@GetMapping("/getHello")
	public String hello() {
		return "<h1 style='background-color: red'>Welcome to Spring Security</h1>";
	}
	
	@PostMapping("/addUserEntity")
	public UserEntity addUserEntity(@RequestBody UserEntity userEntity) {
		
		return iUserEntityService.addUserEntity(userEntity);
	}

	@GetMapping("/findAllUserEntity")
	public List<UserEntity> findAllUserEntity() {
		
		return iUserEntityService.findAllUserEntity();
	}
	
	@GetMapping("/findUserEntityById/{userId}")
	public UserEntity findUserEntityById(@PathVariable long userId) {
		
		return iUserEntityService.findUserEntityById(userId);
	}

}
