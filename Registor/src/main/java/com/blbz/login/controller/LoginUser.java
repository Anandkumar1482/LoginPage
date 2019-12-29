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
import com.blbz.login.serviceimp.LoginDao;
import com.blbz.login.serviceimp.UserDao;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String username = request.getParameter("UserName");
			String password = request.getParameter("Password");

			/*
			 * //getting the data from http request HttpSession
			 * session=request.getSession(); session.setAttribute("UserName", username);
			 * 
			 * String uname=(String) session.getAttribute(username);
			 */
			if (LoginDao.validate(username, password)) {
				List<UserModel> userlist = UserDao.getAllUsers();

				request.setAttribute("list", userlist);
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				session.setMaxInactiveInterval(10);

				RequestDispatcher rd = request.getRequestDispatcher("ViewUser.jsp");
				rd.forward(request, response);
			} else {
				out.print("Sorry username or password incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			out.close();

		}

	}

}
