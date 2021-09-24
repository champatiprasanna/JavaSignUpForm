package com.SignUpForm.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String uref = request.getParameter("usern");
		String passref = request.getParameter("upass");
		String eref =request.getParameter("uemail");
		String nref = request.getParameter("uname");
		String psref = request.getParameter("upassword");
		String lref = request.getParameter("ulocation");
		String upn = request.getParameter("upname");
		String upl =request.getParameter("uplocation");
		//String optref = request.getParameter("options");
		//String ucref =request.getParameter("cname");
		
		String uc = request.getParameter("sign");
		String ul = request.getParameter("login");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cref = DriverManager.getConnection("jdbc:mysql://localhost:3306/syscomsofttech", "root","1234");
			
			
			PreparedStatement pref = cref.prepareStatement("insert into syscom values(?, ?,?,?)");
			pref.setString(1,  eref );
			pref.setString(2, nref);
			pref.setString(3, psref);
			pref.setString(4, lref);
			pref.executeUpdate();
			System.out.println("Sign Up success");
			RequestDispatcher rudref= request.getRequestDispatcher("login.html");
			rudref.forward(request, response);
			pref.close();
			cref.close();
			
			
			
			
			
			/*
			ResultSet refp = plref.executeQuery();
			//PrintWriter pwref = response.getWriter();
			
			if(refp.next()) {
				System.out.println("Login Success");
				//pwref.print("Login success");
				RequestDispatcher rudref= request.getRequestDispatcher("update.html");
				rdref.forward(request, response);
				PreparedStatement puref = cref.prepareStatement("update syscom set name = ?, location = ? where email = ?");
				puref.setString(1, upn);
				puref.setString(2, upl);
				puref.setString(3, uref );
				puref.executeUpdate();
				System.out.println("Hi");
				
			}*/
			
			
			
		
			
			
		}
			/*
			PreparedStatement pref = cref.prepareStatement("insert into signup values(?, ?)");
			pref.setString(1,  uref );
			pref.setString(2, passref);
			pref.executeUpdate();
			PrintWriter pwref = response.getWriter();
			System.out.println("Values inserted");
			
			*/
			
			/*
			PreparedStatement pref = cref.prepareStatement("select name, pass  from signup where name = ? and pass = ?");
			pref.setString(1, uref);
			pref.setString(2, passref);
			
			ResultSet refp = pref.executeQuery();
			PrintWriter pwref = response.getWriter();
			if(refp.next()) {
				
				pwref.print("Login success");
			}else{
				pwref.print("values not matched");
			}
			
			
			
			if(optref.equals("update")) {
			PreparedStatement upref = cref.prepareStatement("update signup set name = ? where name = ?");
			upref.setString(1,ucref);
			upref.setString(2, uref);
			upref.executeUpdate();
			pwref.print("");
			pwref.print("values updated");
			}
			
			if(optref.equals("delete")) {
			PreparedStatement dref = cref.prepareStatement("delete from signup where name = ?");
			dref.setString(1, uref);
			dref.executeUpdate();
			pwref.print("");
			pwref.print("values deleted");
			pref.close();
			cref.close();
			}
			
			if(optref.equals("details")) {
				PreparedStatement dref = cref.prepareStatement("select name, pass from signup where name = ?");
				dref.setString(1, uref);
				ResultSet refps = pref.executeQuery();
				
				if(refps.next()) {
					
					pwref.print(refps.getString("name"));
					pwref.print(refps.getString("pass"));
			
				pref.close();
				cref.close();
				}
			
			
		}
		
		}
		*/
		catch(Exception e) {
			 e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

}
