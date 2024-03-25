package om.sathya.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class MysqlConn2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/santhosh","root","root");
		System.out.println("Connection created with mysql Database");
		
		Statement statement = connection.createStatement(); 
		ResultSet set = statement.executeQuery("select * from emp");
		
		//populate the data to rowSet 
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		cachedRowSet.populate(set);
		
		connection.close();
		
		while(cachedRowSet.next())
		{	System.out.println(cachedRowSet.getInt(1)+" "+cachedRowSet.getString(2)+" "+cachedRowSet.getFloat(3));
		}
		System.out.println("Connection released.....");
	}
}