package com.sathya.jdbcex;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");	
		
		//Call the proceuder 
		CallableStatement callableStatement = connection.prepareCall("{ ? = call getAvg(?,?)}");
		
		//set the inputs 
		callableStatement.setInt(2, 1001);
		callableStatement.setInt(3, 1002);
		
		//register the output parameters
		callableStatement.registerOutParameter(1, Types.DOUBLE);
		
		//execute the procedure the outppu will be stored in reguster paratneter 
		callableStatement.executeUpdate();
		
		//Get the output 
		System.out.println(callableStatement.getDouble(1));
		
		connection.close();
	}
}




