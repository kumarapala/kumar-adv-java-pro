package com.sathya.serlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kiran")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Printwriter used to add the response
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");
		
		//add the response into response object 
		writer.println("<html>");
		writer.println("<h1>Welcome to SathyaTech</h1>");
		writer.println("<h2>This is Servlet First Application</h2>");
		writer.println("<h3>Welcome to Ratan sir Classes</h3>");
		writer.println("</html>");
	}
}