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
<h2>Admin Login Page</h2>
<form action="admin_login" method="post">
Admin Name:<input type="text" name="aname"><br><br>
Password :<input type="password" name="pwd"><br><br>
<button><input type="submit" value="Login"></button>&nbsp &nbsp &nbsp
<button><a href="admin_register.jsp">Register</a></button>&nbsp &nbsp &nbsp
<button><a href="home.html">Back</a></button>
</form>
</body>
</html>