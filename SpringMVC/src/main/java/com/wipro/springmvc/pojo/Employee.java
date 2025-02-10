package com.wipro.springmvc.pojo;
import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {
	private int empno;
	private String ename;
	private double sal;
	
	
	public Employee() {
		System.out.println("Employee Default Constructor.......");
	}
	public Employee(int empno, String ename, double sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		
		System.out.println("Employee Parameterized Constructor.......");
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
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + " ]";
	}
	
	
	
}
