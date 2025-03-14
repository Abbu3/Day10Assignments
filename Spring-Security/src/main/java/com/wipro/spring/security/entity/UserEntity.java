package com.wipro.spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
	@Id
	private long userId;
	private String userName;
	private String password;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserEntity(long userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}


	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
