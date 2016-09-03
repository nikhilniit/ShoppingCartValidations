package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	Connection conn;
	Statement stmt;
  
    public void init() throws ServletException {
    
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
			stmt=conn.createStatement();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String fn =request.getParameter("fname");
		String ln =request.getParameter("lname");
		String em =request.getParameter("emailid");
		String pass =request.getParameter("pass1");
		
		
		try {
			int i= stmt.executeUpdate("insert into register4 values('"+fn+"','"+ln+"','"+em+"','"+pass+"')");
			if (i!= 0)
			{
			out.print("Hello,you are successfully registered");	
			} else {
           out.print("sorry,you are not successfully registered");
			}
		} catch (SQLException e)
		{
		
			e.printStackTrace();
		}
	}
	}


