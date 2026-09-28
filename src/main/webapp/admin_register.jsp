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
<h3 style="color:green;"><%=msg %></h3>
<%
}
%>
<br><br>
<h2>Admin Register Page</h2>
<form action="admin_register" method="post">

Admin Name:<input type="text" name="aname" required="required"><br>
Password :<input type="password" name="pwd" required="required"><br>
First Name:<input type="text" name="fname" required="required"><br>
Last Name:<input type="text" name="lname" required="required"><br>
MailId:<input type="email" name="mailid" required="required"><br>
Phone No:<input type="number" name="phone" required="required"><br>
<input type="submit" value="Register">


</form>
</body>
</html>