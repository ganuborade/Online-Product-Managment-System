package com.servlet;

import java.io.IOException;

import com.dao.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("admin_login.jsp")
                   .forward(request, response);
            return;
        }
		
		String pid = request.getParameter("pid");
		Double newPrice =Double.parseDouble(request.getParameter("price"));
		int newQty =Integer.parseInt(request.getParameter("qty"));
		int k=new ProductDao().updateProduct(pid,newPrice,newQty);
		if(k>0)
		{
			request.setAttribute("msg", "Product Updated Successfully with Product Id: "+pid);
			request.getRequestDispatcher("product_update_success.jsp").forward(request, response);
		}
		else
		{
			 request.setAttribute("msg", "Session Expired");
	            request.getRequestDispatcher("admin_login.jsp")
	                   .forward(request, response);
		}
		
	}

}
