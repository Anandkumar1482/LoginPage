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

import com.blbz.login.model.UserModel;
import com.blbz.login.serviceimp.UserDao;

/**
 * Servlet implementation class EditSave
 */
@WebServlet("/EditUpdate")
public class EditUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("welcome to edit update");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("user id is :"+id);
		String firstname = request.getParameter("firstName");
		System.out.println("fname :"+firstname);
		String lastname = request.getParameter("lastName");
		String username = request.getParameter("userName");
		String email = request.getParameter("email");

		UserModel user = new UserModel();
		user.setId(id);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setUserName(username);
		user.setEmail(email);

		int status = UserDao.update(user);
		//System.out.println("status :"+status);
		if (status > 0) {
			List<UserModel> userlist = UserDao.getAllUsers();
			//System.out.println("list"+userlist);
			request.setAttribute("list", userlist);
			System.out.println("view user ");
			RequestDispatcher rd = request.getRequestDispatcher("ViewUser.jsp");
			rd.forward(request, response);
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
