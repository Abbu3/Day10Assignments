package com.java.wipro.FirstSpringProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.java.wipro.FirstSpringProject.pojo.Address;
import com.java.wipro.FirstSpringProject.pojo.Employee;
import com.java.wipro.FirstSpringProject.repository.EmployeeRepositoryImpl;
import com.java.wipro.FirstSpringProject.service.EmployeeServiceImpl;
@Configuration
@ComponentScan(basePackages = "com.java.wipro.FirstSpringProject.pojo")
public class ConfigurationClass {
	@Bean(name="addr")
	public Address getAddress() {
		Address addr = new Address();
		addr.setAddress("Hyderabad, Telangana");
		return addr;
		
	}
	@Bean(name ="emp")
	@Scope("prototype")
	public Employee getEmployee() {
		Employee emp = new Employee(getAddress());
		emp.setEmpno(234);
		emp.setEname("Smith");
		emp.setSal(3452.12);
		return emp;
	}
	
	@Bean("empRepo")
	public EmployeeRepositoryImpl getEmployeeRepositoryImpl() {
		EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
		employeeRepositoryImpl.display();
		return employeeRepositoryImpl;
	}
	
	@Bean("empService")
	public EmployeeServiceImpl getEmployeeServiceImpl() {
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		employeeServiceImpl.items();
		return employeeServiceImpl;
	}

}
