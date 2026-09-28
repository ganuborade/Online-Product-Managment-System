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
<h3><%=msg %></h3>
<%} %>
</body>
</html>