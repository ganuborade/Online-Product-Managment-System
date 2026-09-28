<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.beans.ProductBean"%>
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
<form action="updateProduct" method="post">
Product Name:<input type="text" name="pname" required="required" value="<%=bean.getPname()%>" readonly="readonly"><br>
Price:<input type="number" name="price" required="required" value="<%=bean.getPrice()%>"><br>
Quantity:<input type="number" name="qty" required="required" value="<%=bean.getQty()%>"><br>
<input type="hidden" name="pid" value="<%= bean.getPid()%>"><br>
<input type="submit" value="UPDATE">

</form>
</body>
</html>