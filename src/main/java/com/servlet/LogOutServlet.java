package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/admin_logout_servlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			session.removeAttribute("name");
			session.invalidate();
			request.setAttribute("msg", "Logged out successfully");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
		
	}

}
