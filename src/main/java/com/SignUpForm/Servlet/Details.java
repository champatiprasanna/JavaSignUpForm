package com.SignUpForm.Servlet;
//Changes made here
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext screfD = getServletContext();
		String srD = (String)screfD.getAttribute("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cref = DriverManager.getConnection("jdbc:mysql://localhost:3306/syscomsofttech", "root","1234");
			PreparedStatement puref = cref.prepareStatement("select name, location from syscom where email = ?");
			puref.setString(1, srD);
		
			ResultSet refp = puref.executeQuery();
			if(refp.next()) {
				System.out.println(refp.getString("name"));
				PrintWriter pw =  response.getWriter();
				pw.print(refp.getString("name"));
			}
			
			
			puref.close();
			cref.close();
			
		}
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}

}
