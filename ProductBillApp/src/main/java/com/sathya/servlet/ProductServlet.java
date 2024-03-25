package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step 1: Read the requested data 
		int proId = Integer.parseInt(request.getParameter("proId"));
		String proName = request.getParameter("proName");
		double proPrice = Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
		
		//Step-2: Process the data. 
		double totalCost = proPrice * proQuantity;
        double discount = 0.0;
        
        if (totalCost > 1000 && totalCost < 5000) {
            discount = 0.05 * totalCost;
        } else if (totalCost >= 5000 && totalCost < 10000) {
            discount = 0.1 * totalCost;
        } else if (totalCost >= 10000) {
            discount = 0.15 * totalCost;
        }
        
        double netAmount = totalCost - discount;
 
		
		//Step-3: Render the response 
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter(); 
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Product Bill Invoice</h1>");
		writer.println("<p>Product ID: " + proId + "</p>");
		writer.println("<p>Product Name: " + proName + "</p>");
		writer.println("<p>Product Cost: $" + proPrice + "</p>");
		writer.println("<p>Product Quantity: " + proQuantity+ "</p>");
		writer.println("<p>Total Bill Amount: $" + totalCost + "</p>");
		writer.println("<p>Discount Amount: $" + discount + "</p>");
		writer.println("<p>Net Amount to Pay: $" + netAmount + "</p>");
		writer.println("</body>");
		writer.println("</html>");
		
	}
}
