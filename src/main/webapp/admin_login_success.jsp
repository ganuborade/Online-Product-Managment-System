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
<h3 style="color:green;"><%=msg %> <%=session.getAttribute("name") %></h3>
<%
}
%>
<br><br>
<button><a href="product.jsp">Add Products</a></button>&nbsp &nbsp
<button><a href="viewAllProducts">View Products</a></button>&nbsp &nbsp
<button><a href="admin_logout_servlet">LogOut</a></button>
</body>
</html>