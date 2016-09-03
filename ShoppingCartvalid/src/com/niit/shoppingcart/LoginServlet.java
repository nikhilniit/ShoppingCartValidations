package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	Connection conn;
	Statement stmt;
  ResultSet rs;
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
		String e =request.getParameter("emailid");
		String ps =request.getParameter("pass1");
		try {
			rs=stmt.executeQuery("select pass1 from register4 where emailid='"+e+"')");
			while(rs.next())
			{
				String pas = rs.getString("pass1");
				if(ps.equals(pas))
				{
					out.print("you are successfully logged in");
				}
				else
				{
					out.print("please enter valid credentials");
				}
			}
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
	}

}
