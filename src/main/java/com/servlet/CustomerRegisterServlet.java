package com.servlet;

import java.io.IOException;

import com.beans.CustomerBean;
import com.dao.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/customer_register")
public class CustomerRegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String pwd = request.getParameter("pwd");
		String mailid = request.getParameter("mailid");
		long phone=Long.parseLong(request.getParameter("phone"));
		
		CustomerBean cb=new CustomerBean(cid,cname,pwd,mailid,phone);
		
		int k = new CustomerDao().insertCustomerInfo(cb);
		if(k>0)
		{
			request.setAttribute("msg", "Customer Registration Successfully");
			request.getRequestDispatcher("customer_login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Customer Registration Failed try Aagin");
			request.getRequestDispatcher("customer_register.jsp").forward(request, response);
		}
	}

}
