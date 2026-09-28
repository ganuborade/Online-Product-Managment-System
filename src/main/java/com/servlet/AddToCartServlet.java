package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.beans.ProductBean;
import com.dao.ProductDao;

@WebServlet("/add_to_cart_servlet")
public class AddToCartServlet extends HttpServlet {
	
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
		
		ArrayList<ProductBean> listOfProduct =(ArrayList<ProductBean>) session.getAttribute("cart");
		listOfProduct.add(bean);
		session.setAttribute("cart", listOfProduct);
		
		request.getRequestDispatcher("add_to_cart.jsp").forward(request, response);
	}

}
