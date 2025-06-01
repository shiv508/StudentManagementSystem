package Com.arch.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			PrintWriter pw = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","shivam107");
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("select username from login where username=? and password=?"); // PreparedStatement is an interface provided by the JDBC // It is used to execute parameterized SQL queries  
	        ps.setString(1,n);
			ps.setString(2,p);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("index1.jsp");
				rd.forward(request,response);
			}
			else
			{
				pw.println("<h1 color:red>Enter Correct Username Or Password</h1>");
				pw.println("<a style=color:red href=login.html>Try again");
			}
			
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace(); 
		}
	}
	}

