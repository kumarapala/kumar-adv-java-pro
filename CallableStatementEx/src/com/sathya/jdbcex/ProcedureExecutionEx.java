package com.sathya.jdbcex;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExecutionEx {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");	
		
		//Call the proceuder 
		CallableStatement callableStatement = connection.prepareCall("{call getSal(?,?)}");
		
		//Set the input data 
		callableStatement.setInt(1, 1002);
		
		//register one variable to store the output 
		callableStatement.registerOutParameter(2, Types.FLOAT);
		
		//execute the procedure the output will be stored in registered param
		callableStatement.executeUpdate();
		
		//Print the out 
		System.out.println(callableStatement.getFloat(2));
		
		connection.close();
	}
}