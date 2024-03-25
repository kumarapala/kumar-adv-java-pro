package com.sathya.productapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId = request.getParameter("proId");
		ProductDao dao = new ProductDao();
		Product existingProduct = dao.findById(proId);
		
		// Sending the product object to edit-form by adding into request object
		request.setAttribute("existingProduct", existingProduct);
		
		// Forward the request to edit-form
		RequestDispatcher dispatcher=request.getRequestDispatcher("edit-form.jsp");
		dispatcher.forward(request, response);
		
	
	}

}
