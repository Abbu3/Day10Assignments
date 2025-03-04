package com.wipro.webflux.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.webflux.entity.User;
import com.wipro.webflux.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImp implements IUserService {
	
	
	@Autowired
	UserRepository repo;
	

	@Override
	public Mono<User> createUser(User user) {
	
		
	
		return repo.save(user);
	}

	@Override
	public Mono<User> getUserById(Long id) {
		
		return repo.findById(id);
				 
	}

	@Override
	public Flux<User> getUsersByName(String name) {
	
		return repo.findByName(name);
	}

	@Override
	public Flux<User> getAllUsers() {
	
		return repo.findAll().delayElements(Duration.ofSeconds(2)); //back pressure
		// Introduce a delay of 10 second between emitting elements
	}

	@Override
	public Mono<User> updateUser(Long id, User user) {
        return repo.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return repo.save(existingUser);
                });
    }

	
}
