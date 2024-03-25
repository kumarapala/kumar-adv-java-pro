package com.sathya.jdbcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionEx1 {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			statement = connection.createStatement();
			
			connection.setAutoCommit(false);
			
			statement.executeUpdate("insert into emp values(1007,'ashok',10000.45)");
			statement.executeUpdate("insert into emp values(1008,'anil',20000.45)");
			statement.executeUpdate("insert into emp values(1009,'anish',30000.45)");
			statement.executeUpdate("delete from emp where empid=1001");
			connection.commit();			
		}
		catch(ClassNotFoundException | SQLException e)
		{	connection.rollback();
			e.printStackTrace();			
		}
		finally {
			if(statement!=null) statement.close();
			if(connection!=null) connection.close();
		}		
	}
}
