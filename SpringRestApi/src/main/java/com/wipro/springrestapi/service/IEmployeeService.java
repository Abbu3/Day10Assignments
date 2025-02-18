package com.wipro.springrestapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.springrestapi.pojo.Employee;

public interface IEmployeeService {
	
	Employee insertEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee findByEmployeeId(int empno);
	ResponseEntity<String> deleteById(int empno);
	List<Employee> findAll();
	Employee findByEname(String ename);
	List<Employee> findBySalGreaterThan(double sal);
	List<Employee> findBySalLessThan(double sal);
	}

