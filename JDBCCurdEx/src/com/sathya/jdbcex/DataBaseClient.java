package com.sathya.jdbcex;

import java.util.List;

public class DataBaseClient {
	public static void main(String[] args) {
		  //C: CREATE Data Saving/insertion by calling save() method  
		  EmployeeDao employeeDao = new EmployeeDao();		
		  int res1 = employeeDao.save(new Employee(1001, "Ratan",10000.56));
		  if(res1==1) {
			  System.out.println("Data inserted Successfully...");
		  }
		  else
		  {  System.out.println("Data insertion fail....");
		  }
		
		  int res2 = employeeDao.save(new Employee(1002,"Anu", 20000.45));
		  if(res2==1) {
			  System.out.println("Data inserted Successfully...");
		  }
		  else
		  {  System.out.println("Data insertion fail....");
		  }	
		
		//R: READ Reading the data from Database based on ID 
		 Employee emp1 = employeeDao.findById(1001); 
		 System.out.println(emp1);
		 
		 Employee emp2 = employeeDao.findById(1002); 
		 System.out.println(emp2);
		 
		//Reading All records 
		List<Employee> emps=employeeDao.findAll();	
		emps.forEach(emp->System.out.println(emp)); 
			
			
		//D: DELETE  Deletion Process 
		int deleteCount = employeeDao.deleteById(1002);
		if (deleteCount == 1) {
			System.out.println("Data deleted Successfully....");
		} else {
			System.out.println("Data deleteion fail");
		}
		
		//Delete by salary 
		int delCount = employeeDao.deleteBySalary(25000);
		System.out.println("Deleted records count...."+delCount);
		  
		// U : UPDATE  update by salary 
		int updateCount = employeeDao.updateBySalary( 10000 , 100);
		System.out.println(updateCount + " rows updated.");		  
	}
}