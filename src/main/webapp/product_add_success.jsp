<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green; align-items: center;">Admin DashBoard</h1>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
%>
<h3 style="color:green"> welcome: <%=session.getAttribute("name") %> <%=msg %></h3>
<%
}
%>
<br><br>
<button><a href="viewAllProducts">View Products</a></button>&nbsp &nbsp
<button><a href="product.jsp">Add Product</a></button>&nbsp &nbsp
<button><a href="admin_login_success.jsp">Back To Dashboard</a></button>&nbsp &nbsp
<button><a href="admin_logout_servlet">LogOut</a></button>&nbsp &nbsp
</body>
</html>