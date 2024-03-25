package com.sathya.productapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public int save(Product product) {
		//Declare the resources 
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		int saveResult = 0;

		try
		{ connection = DatabaseUtils.createConnection();
		  preparedStatement = connection.prepareStatement
				  ("insert into product_data values(?,?,?,?,?,?,?,?)");
		  preparedStatement.setString(1, product.getProId());
		  preparedStatement.setString(2, product.getProName());
              
		  preparedStatement.setDouble(3, product.getProPrice());
		  preparedStatement.setString(4, product.getProBrand());
		  preparedStatement.setString(5, product.getProMadeIn());
             
		  preparedStatement.setDate(6, product.getProMfgDate());
		  preparedStatement.setDate(7, product.getProExpDate());
              
		  preparedStatement.setBytes(8, product.getProImage());
		  saveResult = preparedStatement.executeUpdate();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }	
		  finally {
			  try {
				  if(preparedStatement!=null) 
					  preparedStatement.close(); 
				  if(connection!=null) 
					  connection.close();
			  }
			  catch(SQLException e)
			  {	e.printStackTrace();
			  }
		  }
		  return saveResult;
	}
	
	
	
	public List<Product> findAll() {
        List<Product> productList = new ArrayList<Product>();
       
        //try-with resources :: Resources released automatically
        try(Connection connection = DatabaseUtils.createConnection();
        	Statement statement = connection.createStatement();) 
        {	
        	//Read the data from d store into ResultSet 
        	ResultSet resultSet = statement.executeQuery("select * from product_data");
            
            //Read the data from ResultSet set to Product object & store into List  
            //The loop repeated how many records present in table. 
            while (resultSet.next()) {
	         	  Product product = new Product();
	         	  product.setProId(resultSet.getString("proId"));
				  product.setProName(resultSet.getString("proName"));
				  product.setProPrice(resultSet.getDouble("proPrice"));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  
				  product.setProImage(resultSet.getBytes(8));
				  
				  
				  
				  productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
	
	public int deleteById(String proId) {
		int result = 0;
		try(Connection connection = DatabaseUtils.createConnection()) 
		{	PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product_data WHERE proId = ?");
			preparedStatement.setString(1, proId);
		    result = preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Product findById(String proId) {
		Product product = null; 
	 	try(Connection connection = DatabaseUtils.createConnection()) 
	 	{   // SQL query to retrieve product details by ID
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product_data WHERE proId = ?");
            preparedStatement.setString(1, proId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	  product = new Product();
	         	  product.setProId(resultSet.getString("proId"));
				  product.setProName(resultSet.getString("proName"));
				  product.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  product.setProImage(resultSet.getBytes("proImage"));
			}
        }
	      catch (SQLException e) {
	            e.printStackTrace();
	        } 
	      return product; 
	}



	public int updateById(Product product) {
		
		 String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=? WHERE proId=?";
		int saveResult = 0;
		 try(Connection connection = DatabaseUtils.createConnection()) 
		 	{ 
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
         // Set the parameters for the update statement
		  preparedStatement.setString(1, product.getProName());
             
		  preparedStatement.setDouble(2, product.getProPrice());
		  preparedStatement.setString(3, product.getProBrand());
		  preparedStatement.setString(4, product.getProMadeIn());
            
		  preparedStatement.setDate(5, product.getProMfgDate());
		  preparedStatement.setDate(6, product.getProExpDate());
             
		  preparedStatement.setBytes(7, product.getProImage());
		  preparedStatement.setString(8, product.getProId());
		  
		  saveResult = preparedStatement.executeUpdate();
		  
	}	
		 catch(SQLException e)
		 {e.printStackTrace();			 
		 }
		return saveResult;
	}
	
	
	
	
	
	
	
	
	
	
	
}
