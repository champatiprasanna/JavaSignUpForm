package com.SignUpForm.Servlet;

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String upn = request.getParameter("upname");
		String upl =request.getParameter("uplocation");
		//String uref = request.getParameter("useremail");
		ServletContext scref1 = getServletContext();
		String sr = (String)scref1.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cref = DriverManager.getConnection("jdbc:mysql://localhost:3306/syscomsofttech", "root","1234");
			PreparedStatement puref = cref.prepareStatement("update syscom set name = ?, location = ? where email = ?");
			puref.setString(1, upn);
			puref.setString(2, upl);
			puref.setString(3, sr );
			puref.executeUpdate();
			System.out.println("Values updated");
			
			puref.close();
			cref.close();
			
		}
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
