package com.blbz.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blbz.login.model.UserModel;
import com.blbz.login.serviceimp.UserDao;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id=Integer.parseInt(request.getParameter("id")); 
	        UserModel user=new UserModel();
	        user.setId(id);
	        UserDao.delete(id);  
	       System.out.println("delete a user by id");
	        List<UserModel> userlist = UserDao.getAllUsers();
		
		  for( UserModel list:userlist)
		  {
			  //System.out.println("List :"+list); }
		  }
		  	request.setAttribute("list", userlist);
			request.setAttribute("name", userlist);
	        RequestDispatcher rd = request.getRequestDispatcher("ViewUser.jsp");
			rd.forward(request, response);
	    }  
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
