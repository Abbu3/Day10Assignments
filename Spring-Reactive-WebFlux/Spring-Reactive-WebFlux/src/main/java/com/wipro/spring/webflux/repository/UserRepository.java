package com.wipro.spring.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.spring.webflux.entity.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

}
