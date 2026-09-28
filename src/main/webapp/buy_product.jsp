<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.beans.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ProductBean bean=(ProductBean)request.getAttribute("bean"); 
%>
<form action="buy" method="post">
Product Name:<input type="text" name="pname" value="<%=bean.getPname()%>" readonly="readonly"><br>
product Id:<input type="text" name="pid" value="<%=bean.getPid()%>" readonly="readonly"><br>
Price:<input type="number" name="price" value="<%=bean.getPrice()%>" readonly="readonly"><br>
Available Qty:<input type="number" name="qty" value="<%=bean.getQty()%>" readonly="readonly"><br>
Required Qty:<input type="number" name="rqty" required="required"><br>
<input type="submit" value="Buy">

</form>
</body>
</html>