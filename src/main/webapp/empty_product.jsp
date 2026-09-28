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
String name=(String)session.getAttribute("name");
if(msg!=null && name!=null)
{
%>
<h3 style="color:green;"><%=msg %> <%=session.getAttribute("name") %></h3>
<%
}
%>
<br>
<button><a href="product.jsp">Add Products</a></button>&nbsp &nbsp
<button><a href="admin_login_success.jsp">Back To Dashboard</a></button>
</body>
</html>