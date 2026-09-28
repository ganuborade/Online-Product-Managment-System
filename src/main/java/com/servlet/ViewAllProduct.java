
package com.servlet;

import java.io.IOException;
import java.util.List;

import com.beans.ProductBean;
import com.dao.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewAllProducts")
public class ViewAllProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("msg", "Session Expired");
            request.getRequestDispatcher("admin_login.jsp")
                   .forward(request, response);
            return;
        }

        List<ProductBean> listOfBean = new ProductDao().viewAllProducts();

        if (listOfBean != null && !listOfBean.isEmpty()) {

            request.setAttribute("listOfBean", listOfBean);

            request.setAttribute("msg", "Products fetched successfully");

            request.getRequestDispatcher("view_all_products.jsp")
                   .forward(request, response);

        } else {

            request.setAttribute("msg", "Products list is empty ");

            request.getRequestDispatcher("empty_product.jsp")
                   .forward(request, response);
        }
    }
}
