<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.beans.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<ProductBean> list=(List<ProductBean>)session.getAttribute("cart");
out.println("ProductName &nbsp&nbsp  Price&nbsp&nbsp    Qty&nbsp&nbsp    Subtotal<br>");
double grandTotal=0.0;
for(ProductBean pb:list)
{
	grandTotal+=pb.getPrice();
   out.println(pb.getPname()+"&nbsp&nbsp&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp&nbsp&nbsp"+pb.getQty()+"&nbsp&nbsp&nbsp&nbsp"+pb.getPrice()+"<br>");
}
%>
Grand Total:<%=grandTotal%>
<a href="view_cust_products">Continue Shopping</a>
</body>
</html>