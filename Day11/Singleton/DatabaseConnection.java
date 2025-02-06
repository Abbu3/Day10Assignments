package com.java.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private static DatabaseConnection databaseConnectionObj;
	
	private static Connection conn;
	
	private DatabaseConnection() {
		System.out.println("Connecting to database ");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DatabaseConnection getdatabaseCOnnectionObj() {
		if(databaseConnectionObj == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
