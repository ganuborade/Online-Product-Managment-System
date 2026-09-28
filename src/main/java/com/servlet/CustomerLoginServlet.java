package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.beans.CustomerBean;
import com.beans.ProductBean;
import com.dao.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/customer_login")
public class CustomerLoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mailid = request.getParameter("mailid");
		String pwd = request.getParameter("pwd");
		
		
		CustomerBean bean=new CustomerDao().customerLogin(mailid,pwd);
		if(bean!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("name", bean.getCname());
			session.setAttribute("msg", "Welcome: ");
			session.setAttribute("cart", new ArrayList<ProductBean>());
			response.sendRedirect("customer_login_success.jsp");
//			request.getRequestDispatcher("customer_login_success.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Login Failed Invalid Username or Password");
			response.sendRedirect("customer_login.jsp");
			
//			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
		}
	}

}
