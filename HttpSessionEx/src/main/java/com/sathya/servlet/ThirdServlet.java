package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Display the total details
		// total 6 = req(2) + Cookies(4)
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<pre style='color:Green'>");
		writer.println("User Name..."+cookies[0].getValue());
		writer.println("User Age..."+cookies[1].getValue());
		writer.println("User Qualification..."+cookies[2].getValue());
		writer.println("User Designation..."+cookies[3].getValue());
		writer.println("User Email..."+request.getParameter("email"));
		writer.println("User Mobile..."+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
		
	}
}






