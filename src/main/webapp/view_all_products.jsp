<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.beans.ProductBean"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Products</title>
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
        <th>Quantity</th>
        <th>Edit Product</th>
        <th>Delete Product</th>
    </tr>

<%
    for (ProductBean p : listOfBean) {
%>

    <tr>
        <td><%= p.getPid() %></td>
        <td><%= p.getPname() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQty() %></td>
        <td><a href="edit_product_servlet?pid=<%= p.getPid()%>">Edit</a></td>
        <td><a href="delete_product_servlet?pid=<%= p.getPid()%>">Delete</a></td>
    </tr>

<%
    }
%>
<button><a href="admin_login_success.jsp">Back To Dashboard</a></button>&nbsp &nbsp
<button><a href="product.jsp">Add Product</a></button>&nbsp &nbsp
<button><a href="admin_logout_servlet">LogOut</a></button>
</table>
</body>
</html>

