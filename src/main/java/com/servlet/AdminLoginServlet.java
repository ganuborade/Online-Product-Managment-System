package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.beans.AdminBean;
import com.dao.AdminDao;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		String aName = request.getParameter("aname");
		String pwd = request.getParameter("pwd");
		
		
		AdminBean bean=new AdminDao().adminLogin(aName,pwd);
		if(bean!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("name", bean.getAname());
			request.setAttribute("msg", "Welcome: ");
			request.getRequestDispatcher("admin_login_success.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Login Failed Invalid Username or Password");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}

}
