package com.wipro.springrestapi.controller;

import org.springframework.http.HttpStatus;
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


import com.wipro.springrestapi.pojo.Employee;

@RestController
@RequestMapping("/api")
public class DemoEmployeeController {
	
	@GetMapping("/getEmployee")
	public String getEmployee() {
		return "<h1>Welcome to Spring Rest APi classes</h1>";
	}
	
	@PostMapping("/addEmployee")
	public Employee insertEmployee(@RequestBody Employee employee) {
		
		String res = "Record added " +employee;
		System.out.println(res);
		return  employee;
	}
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employee;
	}
	@DeleteMapping("/deleteEmployee/{empno}")
	public String deleteEmployee(@PathVariable int empno) {
		return "record deletd" +empno;
	}
	@GetMapping("/get/{a}/{b}")
	public int divide(@PathVariable int a, @PathVariable int b)
	{
		return a / b;
	}
	
	@GetMapping("/length/{name}")
	public void length(@PathVariable String name) {
		 name.length();
	}
	
	@ResponseStatus(reason = "A number cannot divide by zero", code = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(Exception.class)
	public void exceptionHandlerMethod() {
		
		
		
	}
}
