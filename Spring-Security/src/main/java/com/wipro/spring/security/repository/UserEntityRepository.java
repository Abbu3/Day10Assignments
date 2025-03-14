package com.wipro.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.spring.security.entity.UserEntity;
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUserName(String userName);
	

}
