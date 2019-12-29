package com.blbz.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blbz.login.model.UserModel;
import com.blbz.login.serviceimp.UserDao;

/**
 * Servlet implementation class ViewUser
 */
@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserModel> userlist = UserDao.getAllUsers();
		for( UserModel list:userlist) {
			//System.out.println("List :"+list);
		}
		request.setAttribute("name", userlist);

//		out.print("<table border='1' width='100%'");
//		out.print(
//				"<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>UserName</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
//		for (UserModel user : userlist) {
//			out.print("<tr><td>" + user.getId() + "</td><td>" + user.getFirstName() + "</td><td>" + user.getLastName() 
//					+ "</td><td>" + user.getUserName() + "</td>" + " <td>" + user.getEmail() + "</td>" 	+ "<td><a href='EditUser?id=" + user.getId()+ "'>edit</a>"
//					+ "</td><td><a href='DeleteUser?id=" + user.getId() + "'>delete</a>"+ "</td></tr>");
//		}
//		
//		
//		out.print("</table>");
//		out.print("<form action='Logout' method='post'>");
//		out.println("<a href='Logout'>Logout</a>");
//		out.println("</form>");
//		out.close();
//		 
		
		/*
		 * System.out.println(request.getSession().getAttribute("user"));
		 * RequestDispatcher rq = request.getRequestDispatcher("ViewUser.jsp");
		 * rq.forward(request, response);
		 */
	}

}
