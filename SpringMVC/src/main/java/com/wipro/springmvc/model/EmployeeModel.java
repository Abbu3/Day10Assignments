package com.wipro.springmvc.model;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wipro.springmvc.pojo.Employee;

@Component
public class EmployeeModel {
	
	int count = 0;
	public int insertAdd(Employee emp) {
		
		
			Connection conn = DBConnection.getDBConnection();
			
			try {
				String insertQuery = "insert into employee values(?,?,?)";
				PreparedStatement statement = conn.prepareStatement(insertQuery);
				statement.setInt(1, emp.getEmpno());
				statement.setString(2, emp.getEname());
				statement.setDouble(3, emp.getSal());
				count = statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;	
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection conn = DBConnection.getDBConnection();
		
		try {
			
			String query = "Select * from employee";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				int int1 = executeQuery.getInt("empno");
				String string = executeQuery.getString("ename");
				double double1 = executeQuery.getDouble("sal");
				Employee e = new Employee(int1, string, double1);
				list.add(e);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
