package com.java.wipro.FirstSpringProject.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {
	private int empno;
	private String ename;
	private double sal;
	@Autowired
	private Address address;
	
	public Employee() {
		System.out.println("Employee Default Constructor.......");
	}
	public Employee(int empno, String ename, double sal, Address address) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.address = address;
		System.out.println("Employee Parameterized Constructor.......");
	}
	public Employee(Address address2) {
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", address=" + address + "]";
	}
	
	
	
}
