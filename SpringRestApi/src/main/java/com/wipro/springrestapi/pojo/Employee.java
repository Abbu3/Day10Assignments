package com.wipro.springrestapi.pojo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Entity
@Data
@NoArgsConstructor
public class Employee {
	@Id
	private int empno;
	private String ename;
	private double sal;
	
	
//	public Employee() {
//		System.out.println("Employee Default Constructor.......");
//	}
//	public Employee(int empno, String ename, double sal) {
//		super();
//		this.empno = empno;
//		this.ename = ename;
//		this.sal = sal;
//		
//		System.out.println("Employee Parameterized Constructor.......");
//	}
//	
//	public int getEmpno() {
//		return empno;
//	}
//	public void setEmpno(int empno) {
//		this.empno = empno;
//	}
//	public String getEname() {
//		return ename;
//	}
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//	public double getSal() {
//		return sal;
//	}
//	public void setSal(double sal) {
//		this.sal = sal;
//	}
//	
//	@Override
//	public String toString() {
//		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + " ]";
//	}
	
	
	
}
