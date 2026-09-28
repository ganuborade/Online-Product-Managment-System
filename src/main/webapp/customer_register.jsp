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
<h2>Customer Register Page</h2>
<form action="customer_register" method="post">

Customer ID:<input type="text" name="cid" required="required"><br>
Customer Name:<input type="text" name="cname" required="required"><br>
Password :<input type="password" name="pwd" required="required"><br>
MailId:<input type="email" name="mailid" required="required"><br>
Phone No:<input type="tel" name="phone" required="required"><br>
<input type="submit" value="Register">

</form>
</body>
</html>