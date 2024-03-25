package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	//Step-1: Read the requested data. 
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String mobile = request.getParameter("mobile");
	        String email = request.getParameter("email");
	        String gender = request.getParameter("gender");
	        String dob = request.getParameter("dob");
	        String[] qualifications = request.getParameterValues("qualification");
	        String country = request.getParameter("country");
	        String[] languages = request.getParameterValues("languages");
	        String comments = request.getParameter("comments");
	        
	        //Step-2: Process the data. 
	        
	        String qual = String.join(",", qualifications);
	        PrintWriter writer = response.getWriter();
	        writer.println("");
	        
	}
}
