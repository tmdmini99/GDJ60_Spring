<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가버렷</title>
</head>
<body>
	<h1>Product Detail</h1>
	<%
		ProductDTO productDTO = (ProductDTO)request.getAttribute("dto");
	
	%>
	<h3><%=productDTO.getProductName() %></h3>
	<h3><%=productDTO.getProductDetail() %></h3>
	
	<hr>
	
	<h3>${requestScope.dto.productName}</h3>
	<h3>${requestScope.dto.getProductDetail()}</h3>
	<h3>${dto.getProductDetail()}</h3>
	<!-- 스코프명 생략 가능 -->
	<h3>${dto.productJumsu +dto.productNum}</h3>
	
</body>
</html>