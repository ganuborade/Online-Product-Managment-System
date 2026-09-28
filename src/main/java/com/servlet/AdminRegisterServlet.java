package com.servlet;

import java.io.IOException;

import com.beans.AdminBean;
import com.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin_register")
public class AdminRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String aname = request.getParameter("aname");
		String pwd = request.getParameter("pwd");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String mailid = request.getParameter("mailid");
		long phone=Long.parseLong(request.getParameter("phone"));
		
//		AdminBean ab=new AdminBean(aname,pwd,fName,lName,mailid,phone);  //or using setter
		AdminBean ab=new AdminBean();
		ab.setAname(aname);
		ab.setPwd(pwd);
		ab.setFname(lName);
		ab.setLname(lName);
		ab.setMailid(mailid);
		ab.setPhone(phone);
		
		int rowCount=new AdminDao().adminRegister(ab);
		if(rowCount>0)
		{
			request.setAttribute("msg", "Admin Registration Successfully");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Admin Registration Failed try Aagin");
			request.getRequestDispatcher("admin_register.jsp").forward(request, response);
		}
	}

}
