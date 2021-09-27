package com.SignUpForm.Servlet;
//Delete servlet

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext screfd = getServletContext();
		String srd = (String)screfd.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cref = DriverManager.getConnection("jdbc:mysql://localhost:3306/syscomsofttech", "root","1234");
			PreparedStatement puref = cref.prepareStatement("delete from syscom where email = ?");
			puref.setString(1, srd);
			
			puref.executeUpdate();
			System.out.println("Values deleted");
			
			puref.close();
			cref.close();
			
		}
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}

}
