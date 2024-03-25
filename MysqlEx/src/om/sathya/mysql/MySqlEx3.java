package om.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlEx3 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/santhosh","root","root");
		System.out.println("Connection created with mysql Database");
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from emp");
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getColumnTypeName(2));
		System.out.println(metaData.getColumnDisplaySize(2));
		connection.close();
	}
}
