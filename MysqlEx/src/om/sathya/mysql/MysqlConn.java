package om.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/santhosh","root","root");
		System.out.println("Connection created with mysql Database");
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
		preparedStatement.setInt(1, 111);
		preparedStatement.setString(2, "santhosham");
		preparedStatement.setFloat(3, 10000.45f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 222);
		preparedStatement.setString(2, "jithendar");
		preparedStatement.setFloat(3, 20000.45f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 333);
		preparedStatement.setString(2, "meharin");
		preparedStatement.setFloat(3, 30000.45f);
		preparedStatement.addBatch(); 
		
		preparedStatement.executeBatch();
		
		connection.close();
		System.out.println("Connection released.....");
	}
}



