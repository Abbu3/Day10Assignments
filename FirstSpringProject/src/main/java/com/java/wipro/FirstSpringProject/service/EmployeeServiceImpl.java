package com.java.wipro.FirstSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.wipro.FirstSpringProject.pojo.Employee;
import com.java.wipro.FirstSpringProject.repository.IEmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	Employee employee;
	@Autowired
	IEmployeeRepository iEmployeeRepository;

	@Override
	public void items() {
		System.out.println("Employee Service");
		System.out.println("The employee object is " +employee);
		System.out.println("The employee repo object is " +iEmployeeRepository);
	}

}
