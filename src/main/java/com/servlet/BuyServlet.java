package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.beans.BuyProductBean;
import com.beans.ProductBean;
import com.dao.ProductDao;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("customer_login.jsp")
                   .forward(request, response);
            return;
        }
        
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		double price =Double.parseDouble(request.getParameter("price"));
		int qty =Integer.parseInt(request.getParameter("qty"));
		int rQty =Integer.parseInt(request.getParameter("rqty"));
		
		if(rQty>qty) {
			request.setAttribute("msg", "out of stock");
			request.getRequestDispatcher("out_of_stock.jsp").forward(request, response);
			
		
		}
		else
		{
			int removeQty = new ProductDao().removeQty(pid,qty);
			double totalBill=rQty*price;
			
			BuyProductBean bp=new BuyProductBean();
			bp.setPid(pid);
			bp.setPname(pname);
			bp.setPrice(price);
			bp.setrQty(rQty);
			bp.setTotalBill(totalBill);
			
			request.setAttribute("bp", bp);
			
			request.getRequestDispatcher("product_bill.jsp").forward(request, response);
			
		}
	}

}
