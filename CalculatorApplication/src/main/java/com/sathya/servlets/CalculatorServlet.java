package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1:  Get the requested data 
		int num1 = Integer.parseInt(request.getParameter("first"));
		int num2 = Integer.parseInt(request.getParameter("second"));
		String operation = request.getParameter("operation");	
		
		//Step 2: Process the data 
		int result = 0; 	
		switch(operation)
		{	case "+":  result = num1 + num2; 
						break;
			case "-":  result = num1 - num2; 
						break;
			case "*":  result = num1 * num2; 
						break;
			case "/":  result = num1 / num2; 
						break;
			case "%":  result = num1 % num2; 
						break;
		}
				
		//Step 3: Render the response 
		
	
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1> Your Results...</h1>");
		writer.println("<p>Your First Number.."+num1+"</p>");
		writer.println("<p>Your Second Number.."+num2+"</p>");
		writer.println("<p>Your Operation Symbol.."+operation+"</p>");
		writer.println("<p>Your Result..."+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.html");
		dispatcher.include(request, response);
		
	}
}