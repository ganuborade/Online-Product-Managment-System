<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green; align-items: center;">Customer DashBoard</h1>
<%
String msg=(String)session.getAttribute("msg");
if(msg!=null)
{
%>
<h3 style="color:green;"><%=msg %> <%=session.getAttribute("name") %></h3>
<%
}
%>
<br><br>
<a href="view_cust_products">View All Products</a>
</body>
</body>
</html>
