package com.wipro.springrestapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.wipro.springrestapi.pojo.Employee;
import com.wipro.springrestapi.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee insertEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findByEmployeeId(int empno) {
		
		return employeeRepository.findById(empno).orElse(null);
	}

	@Override
	public ResponseEntity<String> deleteById(int empno) {
		
		employeeRepository.deleteById(empno);
		return new ResponseEntity<String>("Record deleted", HttpStatus.OK);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll(Sort.by("ename"));
	}

	@Override
	public Employee findByEname(String ename) {
		
		return employeeRepository.findByEname(ename);
	}

	@Override
	public List<Employee> findBySalGreaterThan(double sal) {
		
		return employeeRepository.findBySalGreaterThan(sal);
	}

	@Override
	public List<Employee> findBySalLessThan(double sal) {
		// TODO Auto-generated method stub
		return employeeRepository.findBySalLessThan(sal);
	}

}
