<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.beans.BuyProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Order Summary</h1><br>
Welcome: <%=session.getAttribute("name") %> <br>
<%
BuyProductBean bean=(BuyProductBean)request.getAttribute("bp");
%>
Product Id: <%=bean.getPid() %><br>
Product Name: <%=bean.getPname() %><br>
Price: <%=bean.getPrice() %><br>
Purchease Qty: <%=bean.getrQty() %><br>
Total Bill: <%=bean.getTotalBill() %><br>
<a href="view_cust_products">Continue Shoping</a>
</body>
</html>