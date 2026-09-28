<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
%>
<h2 style="color:green"><%=msg %></h2>
<%
}
%>
<h2>Customer Login Page</h2>
<form action="customer_login" method="post">
EMAIL ADDRESS:<input type="email" name="mailid"><br><br>
Password :<input type="password" name="pwd"><br><br>
<button><input type="submit" value="Login"></button>&nbsp &nbsp &nbsp
<button><a href="customer_register.jsp">Register</a></button>&nbsp &nbsp &nbsp
<button><a href="home.html">Back</a></button>
</form>
</body>
</html>