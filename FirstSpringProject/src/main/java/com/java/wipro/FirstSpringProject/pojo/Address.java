package com.java.wipro.FirstSpringProject.pojo;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String address;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
	
	
	
	
	

}
