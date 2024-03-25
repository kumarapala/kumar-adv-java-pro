package com.sathya.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//step-1: Load the driver 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded successfully....");
	
	//step 2: Create the Connection 
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	System.out.println("Connection Created Successfully....");
	
	//Step 3: static query 
	Statement statement = connection.createStatement();
	String q = "create table emp(id number,name varchar2(30),salary number)";
	int res = statement.executeUpdate(q);
	System.out.println("Table created successfully..."+res);
	
	
	//step 4: Release the connection 
	connection.close();
	System.out.println("Connection closed successfully...");
	}
}






