package com.servlet;

import java.io.IOException;

import com.beans.ProductBean;
import com.dao.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("admin_login.jsp")
                   .forward(request, response);
            return;
        }
		
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		double price =Double.parseDouble(request.getParameter("price"));
		int qty =Integer.parseInt(request.getParameter("qty"));
		
		ProductBean bean=new ProductBean();
		bean.setPid(pid);
		bean.setPname(pname);
		bean.setPrice(price);
		bean.setQty(qty);
		
		int k=new ProductDao().addProduct(bean);
		if(k>0)
		{
			request.setAttribute("msg", "Product Added Successfully with Product Id: "+pid);
			request.getRequestDispatcher("product_add_success.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Product Not Added Try Aagin");
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		
		
		
	}

}
