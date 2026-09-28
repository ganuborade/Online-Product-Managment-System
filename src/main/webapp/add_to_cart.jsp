<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.beans.ProductBean"%> 
<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="UTF-8"> 
    <title>Shopping Cart</title> 
</head> 
<body> 

    <table border="1">
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Qty</th>
                <th>SubTotal</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
            ArrayList<ProductBean> cart = (ArrayList<ProductBean>) session.getAttribute("cart");
            double grandTotal = 0.0;
            
            if (cart != null) {
                for (ProductBean pb : cart) { 
                    int pQty = 1;
                    double subTotal = pb.getPrice() * pQty;
                    grandTotal += subTotal;
            %>
            
            <tr>
                <td><%= pb.getPid() %></td>
                <td><%= pb.getPname() %></td>
                <td><%= pb.getPrice() %></td>
                <td><%= pQty %></td>
                <td><%= subTotal %></td>
                <td><a href="remove_prod?pid=<%= pb.getPid() %>">Remove Product</a></td>
            </tr>
            <% 
                } 
            } 
            %>
        </tbody>
    </table>

    <p>Grand Total: <%= grandTotal %></p>
    
    <a href='view_cust_products'">Add More</a>&nbsp
    <a href="cart_summary.jsp">Chekout</a>

</body> 
</html>
