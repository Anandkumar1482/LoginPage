package com.blbz.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blbz.login.model.UserModel;
import com.blbz.login.serviceimp.UserDao;

/**
 * Servlet implementation class Registor
 */
@WebServlet("/Registor")
public class Registor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
      
        String firstName=request.getParameter("FirstName");
        String lastName=request.getParameter("LastName"); 
        String userName=request.getParameter("UserName");
        String password=request.getParameter("Password");
        String email=request.getParameter("Email");  
          
        UserModel user=new UserModel();  
    
        user.setFirstName(firstName); 
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);  
        user.setEmail(email);  
          //System.err.println(user.toString());
        int status=UserDao.save(user);  
        if(status>0){  
            out.print("<p>Record saved successfully! Now you can Login</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  

	
}


