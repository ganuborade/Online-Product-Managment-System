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
<h3 style="color:green"><%=msg %> <%=session.getAttribute("name") %></h3>
<%
}
%>
<form action="addProduct" method="post">

Product Id:<input type="text" name="pid"><br>
Product Name:<input type="text" name="pname"><br>
Price:<input type="number" name="price"><br>
Quantity:<input type="number" name="qty"><br>
<input type="submit" value="ADD_PRODUCT">
</form>
</body>
</html>