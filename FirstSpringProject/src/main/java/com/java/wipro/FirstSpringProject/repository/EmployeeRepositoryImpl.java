package com.java.wipro.FirstSpringProject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.wipro.FirstSpringProject.pojo.Employee;
import com.java.wipro.FirstSpringProject.service.IEmployeeService;
@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository {
	@Autowired
	Employee employee;
	
	




	@Override
	public void display() {
		System.out.println("Employee Repository");
		System.out.println("The object of employee is " +employee);
		//System.out.println("The object of employee service is " +iEmployeeService);

	}

}
