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


@WebServlet("/buy_product_servlet")
public class BuyProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("customer_login.jsp")
                   .forward(request, response);
            return;
        }
        
		String pid = request.getParameter("pid");
		
		ProductBean bean = new ProductDao().getProductById(pid);
		
		if (bean != null) {

            request.setAttribute("bean", bean);       

            request.getRequestDispatcher("buy_product.jsp")
                   .forward(request, response);

        } 
	}

}
