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
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
		           throws ServletException, IOException {  
		   
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        out.println("<h1>Edit and Update User</h1>");  
		        String sid=request.getParameter("id");  
		        int id=Integer.parseInt(sid);  
		          
		        UserModel user=UserDao.getUserById(id);  
		          
		        out.print("<form action='EditUpdate' method='post'>");  
		        out.print("<table");  
		        out.print("<tr><td> Id</td><td><input type='text' name='id' value='"+user.getId()+"' readonly/></td></tr>");  
		        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstName' value='"+user.getFirstName()+"'/></td></tr>");  
		        out.print("<tr><td>LastName:</td><td><input type='text' name='lastName' value='"+user.getLastName()+"'/></td></tr>"); 
		        out.print("<tr><td>UserName:</td><td><input type='text' name='userName' value='"+user.getUserName()+"'/></td></tr>"); 
		        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+user.getEmail()+"'/></td></tr>");  
		     
		        out.print("</td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit&save'/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");  
		          
		        out.close(); 
		    }  
		 	          
		 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
