package om.sathya.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlEx4 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/santhosh","root","root");
		System.out.println("Connection created with mysql Database");
		
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(metaData.getDatabaseProductVersion());
		System.out.println(metaData.getDriverName());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getURL());
		connection.close();
	}
}





