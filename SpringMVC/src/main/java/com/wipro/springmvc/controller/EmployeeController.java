package com.wipro.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.wipro.springmvc.model.EmployeeModel;
import com.wipro.springmvc.pojo.Employee;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeModel employeeModel;
	
	@RequestMapping(path = "/getEmployees", method = RequestMethod.GET)
	@ResponseBody
	public String submit() {
		return "<h1> Welcome to SpringMVC</h1>";
	}
	
	@RequestMapping(value = "/getDisplay", method = RequestMethod.GET)
	public String getDispaly() {
		
		return "display";  ///view name
	}
	@RequestMapping(path = "/addEmployees", method = RequestMethod.POST)
	public String addEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		session.setAttribute("e1", emp);
		return "success";
	}
	
	@RequestMapping(path = "/postEmployees", method = RequestMethod.POST)
	public String getEmployees(@ModelAttribute Employee emp, HttpSession session) {
		
		session.setAttribute("emp", emp);
		
		employeeModel.insertAdd(emp);
		
		return "AllEmployees";
	}
	
	@RequestMapping(path = "/getEmployeesData", method = RequestMethod.GET)
	public String getEmployeesData(@ModelAttribute Employee emp, HttpSession session) {
		session.setAttribute("emp", emp);
		
		employeeModel.getAllEmployees();
		
		return "EmployeesData";
	}
	
	
}
