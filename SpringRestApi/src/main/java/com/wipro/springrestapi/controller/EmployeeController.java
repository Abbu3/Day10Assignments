package com.wipro.springrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springrestapi.exception.DeleteNotFoundException;
import com.wipro.springrestapi.exception.EmpnoNotFoundException;
import com.wipro.springrestapi.pojo.Employee;
import com.wipro.springrestapi.service.IEmployeeService;

import ch.qos.logback.classic.util.LogbackMDCAdapterSimple;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	IEmployeeService iEmployeeService;
	
	@PostMapping("/addEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return iEmployeeService.insertEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return iEmployeeService.updateEmployee(employee);
	}
	
	@GetMapping("/findByEmployeeId/{empno}")
	public Employee findByEmployeeId(@PathVariable int empno) throws EmpnoNotFoundException {
		
		Employee byEmployeeId = iEmployeeService.findByEmployeeId(empno);

		
		if(byEmployeeId != null) {
			return byEmployeeId;
		} else {
			 throw new EmpnoNotFoundException();
		}
	}

	@DeleteMapping("/deleteByEmployeeId/{empno}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empno) throws DeleteNotFoundException {
		
		ResponseEntity<String> deleteById = iEmployeeService.deleteById(empno);
		if(deleteById != null) {
			return deleteById;
		} else {
			throw new DeleteNotFoundException();
		}
		//return new ResponseEntity<String>("Record deleted", HttpStatus.OK);
	}

	@GetMapping("/findAllEmployees")
	public List<Employee> findAllEmployees() {
		return iEmployeeService.findAll();
	}
	
	@GetMapping("/findByEname/{ename}")
	public Employee findByEname(@PathVariable String ename) {
		
		return iEmployeeService.findByEname(ename);
	}	
	
	@GetMapping("/findBySalGreaterThan/{sal}")
	public List<Employee> findBySalGreaterThan(@PathVariable double sal) {
		
		return iEmployeeService.findBySalGreaterThan(sal);
	}
	@GetMapping("/findBySalLessThan/{sal}")
	public List<Employee> findBySalLessThan(double sal) {
		return iEmployeeService.findBySalLessThan(sal);
	}
	
}
