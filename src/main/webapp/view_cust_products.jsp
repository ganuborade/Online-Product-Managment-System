<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.beans.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
    <%= request.getAttribute("msg") %>
</h3>

<%
    List<ProductBean> listOfBean =
        (List<ProductBean>) request.getAttribute("listOfBean");
%>

<table border="1">

    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Available Qty</th>
        
    </tr>

<%
    for (ProductBean p : listOfBean) {
%>

    <tr>
        <td><%= p.getPid() %></td>
        <td><%= p.getPname() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQty() %></td>
        <td><a href="add_to_cart_servlet?pid=<%= p.getPid()%>">Add To Cart</a></td>
        <td><a href="buy_product_servlet?pid=<%= p.getPid()%>">Buy Now</a></td>
    </tr>

<%
    }
%>
<button><a href="customer_login_success.jsp">Back To Dashboard</a></button>&nbsp &nbsp
<button><a href="customer_logout_servlet">LogOut</a></button>
</table>
</body>
</html>