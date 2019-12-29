package com.blbz.login.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthentificationFilter
 */
@WebFilter("/LoginUserAut")
public class AuthentificationFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		
		
		String name = request.getParameter("UserName");
		String pswd = request.getParameter("Password");
		
		if(name!=null && pswd!=null) {
			request.getRequestDispatcher("/LoginUser").forward(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
