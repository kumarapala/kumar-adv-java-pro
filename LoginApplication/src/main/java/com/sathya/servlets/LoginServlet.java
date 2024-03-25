package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1 : Read the form data 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		/*
		 * //step-2: Process the Data String status; if(username.equals("sathya")&&
		 * password.equals("Sathya@123")) { status = "Login Successfull..."; } else {
		 * status = "Login Fail..."; }
		 * 
		 * //step-3: Render the response to client PrintWriter writer =
		 * response.getWriter(); response.setContentType("text/html");
		 * writer.println("<html>"); writer.println("<h1>Login Status....</h1>"+status);
		 * writer.println("</html>");
		 */
		
		if (username.equals("sathya") && password.equals("Sathya@123")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("Login Fail heck the credentials once...");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
		} 
		
		
		if (username.equals("sathya") && password.equals("Sathya@123")) {
			response.sendRedirect("http://www.tcs.com");
		} else {
			response.sendError(808, "Login Fail check the details Santhosh");
		}
 
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		if(username.equals("sathya")&& password.equals("Sathya@123"))
		{	writer.println("Login Successfull <br>");
			writer.println("<a href='http://www.sathyatech.com'>Click here to OPen the sathya website</a>");
		}
		else
		{	writer.println("Login Fail <br>");
			writer.println("<a href='login.html'>Click here to Login Page</a>");
		}
	}
}






