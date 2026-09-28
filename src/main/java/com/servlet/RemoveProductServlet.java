package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.beans.ProductBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/remove_prod")
public class RemoveProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("customer_login.jsp")
                   .forward(request, response);
            return;
        }
        
		String pid = request.getParameter("pid");
		ArrayList<ProductBean> cart=(ArrayList<ProductBean>)session.getAttribute("cart");
		if (cart != null && pid != null) {
            for (ProductBean pb : cart) {
                
                if (pid.equals(pb.getPid())) {                
                    cart.remove(pb);
                    break; // Exit loop immediately after removing to avoid ConcurrentModificationException
                }
            }
            session.setAttribute("cart", cart);
        }
		request.getRequestDispatcher("add_to_cart.jsp").forward(request, response);
	}

}
