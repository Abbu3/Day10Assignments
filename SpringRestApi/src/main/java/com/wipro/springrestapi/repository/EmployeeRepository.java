package com.wipro.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.springrestapi.pojo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEname(String ename);
	
	List<Employee> findBySalGreaterThan(double sal);
	
	List<Employee> findBySalLessThan(double sal);
	}
