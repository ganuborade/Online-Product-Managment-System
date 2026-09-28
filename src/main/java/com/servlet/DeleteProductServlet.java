package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.beans.ProductBean;
import com.dao.ProductDao;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/delete_product_servlet")
public class DeleteProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("admin_login.jsp")
                   .forward(request, response);
            return;
        }
		
		String pid = request.getParameter("pid");
		
		int k=new ProductDao().deleteProduct(pid);
		if(k>0)
		{

//			request.getRequestDispatcher("viewAllProducts").forward(request, response);
			request.setAttribute("msg", "Product Deleted Successfully with Product Id: "+pid);
			request.getRequestDispatcher("product_delete_success.jsp").forward(request, response);
		}
		else
		{
			 request.setAttribute("msg", "Session Expired");
	            request.getRequestDispatcher("admin_login.jsp")
	                   .forward(request, response);
		}
		
		
		
	}

}
