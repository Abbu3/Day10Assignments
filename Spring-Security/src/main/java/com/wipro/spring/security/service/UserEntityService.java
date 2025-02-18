package com.wipro.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.spring.security.entity.UserEntity;
import com.wipro.spring.security.repository.UserEntityRepository;

@Service
public class UserEntityService implements IUserEntityService {
	@Autowired
	UserEntityRepository userRepository;
	//@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserEntity addUserEntity(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		return userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> findAllUserEntity() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity findUserEntityById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}
	
	

}
