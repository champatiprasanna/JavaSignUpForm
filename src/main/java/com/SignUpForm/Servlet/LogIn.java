package com.SignUpForm.Servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uref = request.getParameter("useremail");
		String passref = request.getParameter("upass");
		ServletContext scref = getServletContext();
		scref.setAttribute("email", uref);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cref = DriverManager.getConnection("jdbc:mysql://localhost:3306/syscomsofttech", "root","1234");
			

		PreparedStatement plref = cref.prepareStatement("select email, password  from syscom where email = ? and password = ?");
		plref.setString(1, uref);
		plref.setString(2, passref);
		ResultSet refp = plref.executeQuery();
		PrintWriter pwref = response.getWriter();
		
		if(refp.next()) {
			
			//pwref.print("Login success");
			
			RequestDispatcher rudref= request.getRequestDispatcher("options.html");
			rudref.forward(request, response);
			
		
		}
		else {
			pwref.print("Login unsuccess");
		}
		}
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
