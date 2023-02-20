package com.loginpage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		   
		try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab?useSSL=false", "root", "1234");
			 
			 PreparedStatement pst = con.prepareStatement("select * from users where username = ? and password = ? ");
			 
			 pst.setString(1, username);
			 pst.setString(2, password);
			
			 ResultSet rs = pst.executeQuery();
			 
			 if (rs.next()) {

	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<html><body>");
	                out.println("<h1>Welcome, " + username + "!</h1>");
	                out.println("</body></html>");
			
			 } else {	
				 
				 	response.setContentType("text/html");
				 	PrintWriter out = response.getWriter();
				 	out.println("<html><body>");
				 	out.println("<h1>Error: Invalid username or password</h1>");
				 	out.println("</body></html>");
			}
			 
			 rs.close();
			 pst.close();
			 con.close();
 
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			response.setContentType("text/html");
		 	PrintWriter out = response.getWriter();
		 	out.println("<html><body>");
		 	out.println("<h1>Finally Block</h1>");
		 	out.println("</body></html>");
		}
	}
}
