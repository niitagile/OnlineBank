package com.businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
       
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//to print output on browser
		PrintWriter out=response.getWriter();
		String username=request.getParameter("txtuname");
		String pword=request.getParameter("txtpword");
		if(username.equalsIgnoreCase("admin")&& pword.equals("admin@123")){
			RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("invalid user name or password");	
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
	/*	out.println("Welcome"+username);
	
		out.println("your password is "+pword);*/
	}

}
