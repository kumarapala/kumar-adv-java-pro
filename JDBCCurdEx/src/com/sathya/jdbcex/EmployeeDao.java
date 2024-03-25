package com.sathya.jdbcex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public int save(Employee emp)
	{	Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		
		try {
		//Get the Connection 
		connection = DbConnection.createConnection();
		//create the PS object 
		preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
		// Read the data from emp object and set to parameters
		preparedStatement.setInt(1, emp.getEmpId());
		preparedStatement.setString(2, emp.getEmpName());
		preparedStatement.setDouble(3, emp.getEmpSalary());
		count = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		finally {
			try {
			if(connection!=null)
				connection.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			}
			catch(SQLException e) 
			{e.printStackTrace();
			}
		}
		return count;
	}
	
	public Employee findById(int empId)
	{	Employee employee = null;
		//try-with resourses 
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empId=?"))
		{	//set the data to parameter 
			preparedStatement.setInt(1, empId);
			
			//execute the query 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//If the record is present execute below code, if the record is not present it returns null.
			if(resultSet.next()) {
			//Reading the data from ResultSet setting to Employee
			employee = new Employee();
			employee.setEmpId(resultSet.getInt(1));
			employee.setEmpName(resultSet.getString(2));
			employee.setEmpSalary(resultSet.getDouble(3));
			}
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> findAll()
	{	//Create the List to strore the group of records
		List<Employee> emps=new ArrayList<Employee>();
		try(Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement())
		{
			ResultSet resultSet = statement.executeQuery("select * from emp");
			 
			//while loop reading all records one by one 
			while(resultSet.next())
			{
			//read the Data from resultSet & set to employee
			Employee employee=new Employee();
			employee.setEmpId(resultSet.getInt(1));
			employee.setEmpName(resultSet.getString(2));
			employee.setEmpSalary(resultSet.getDouble(3));
			//add employee object into LIST
			emps.add(employee);
			}
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return emps;
	}
		
	public int deleteById(int empId)
	{	int count = 0; 
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empId=?"))
			{	//set the data to parameter 
				preparedStatement.setInt(1, empId);
				count = preparedStatement.executeUpdate();
			}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return count;
	}
	
	public int deleteBySalary(int empSalary)
	{	int count = 0; 
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empSalary>?"))
			{	//set the data to parameter 
				preparedStatement.setInt(1, empSalary);
				count = preparedStatement.executeUpdate();
			}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return count;
	}
	
	public int updateBySalary( double currentSalary , double incSalary) {
		int updateCount = 0;
		
		try ( Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(" UPDATE emp SET empSalary = empSalary + ? WHERE empSalary > ? ")) {
			
			preparedStatement.setDouble(1, incSalary);
			preparedStatement.setDouble(2, currentSalary);
			
			updateCount = preparedStatement.executeUpdate();
			
		}
		catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return updateCount;
	}
}
