package com.sathya.productapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId = request.getParameter("proId");
        String updatedProductName = request.getParameter("proName");
        
        double updatedProductPrice = Double.parseDouble(request.getParameter("proPrice"));
        String updatedProductBrand = request.getParameter("proBrand");
        
        String updatedProductMadeIn = request.getParameter("proMadeIn");
        Date updatedProductMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
        Date updatedProductExpDate = Date.valueOf(request.getParameter("proExpDate"));
      
         Product product = new Product();
	     product.setProId(proId);
	     product.setProName(updatedProductName);
	     product.setProPrice(updatedProductPrice);
	     product.setProBrand(updatedProductBrand);
	     product.setProMadeIn(updatedProductMadeIn);
	     product.setProMfgDate(updatedProductMfgDate);
	     product.setProExpDate(updatedProductExpDate);
	     
		Part filePart = request.getPart("newProImage"); // "newProImage" is the name of your file input field
		if (filePart != null && filePart.getSize() > 0) {
		    InputStream inputStream = filePart.getInputStream();
		    byte[] newImageData = IOUtils.toByteArray(inputStream);
		    product.setProImage(newImageData);
		    
		} else {
			Part file = request.getPart("existingImage");
			InputStream inputStream =  file.getInputStream();
			byte[] existingImage = IOUtils.toByteArray(inputStream);
			product.setProImage(existingImage);
		}
		
		ProductDao dao = new ProductDao();
		int result = dao.updateById(product);
		
		 if(result == 1)
		    {  	//To send the data to JSP file add the data into request object 
		    	//request.setAttribute("saveResult", result);
		    	
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
		    	dispatcher.forward(request, response);
		    }
		    else
		    { 	response.setContentType("text/html");
		    	PrintWriter writer = response.getWriter();
		    	writer.println("Data Updation fail Check once..."+result);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
		    	dispatcher.include(request, response);
		    }
		
		
	}

}
