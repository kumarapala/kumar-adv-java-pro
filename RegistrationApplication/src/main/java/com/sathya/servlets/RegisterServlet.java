package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1: from request object read the data 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		
		String[] quals = request.getParameterValues("qualification");
		String country = request.getParameter("country");
		
		String[] languages =  request.getParameterValues("languages");
		String comments = request.getParameter("comments");
		
		//Step-2: Process the data 
		String q = String.join(",", quals);
		String l = String.join("-", languages);
		
		//Step-3: Render the reponse 
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Your user Name..."+username+"<br>");
		writer.println("Your Password..."+password+"<br>");
		
		writer.println("Your Mobile Number..."+mobile+"<br>");
		writer.println("Your email..."+email+"<br>");
		
		writer.println("Your Gender..."+gender+"<br>");
		writer.println("Your DOB..."+dob+"<br>");
		
		writer.println("Your qualification..."+q+"<br>");
		writer.println("Your Country..."+country+"<br>");
		
		writer.println("Your Languages..."+l+"<br>");
		writer.println("Your Comments..."+comments+"<br>");

		writer.println("</body>");
		writer.println("</html>");
	}
}












