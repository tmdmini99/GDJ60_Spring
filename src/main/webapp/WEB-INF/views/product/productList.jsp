<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기모찌</title>
  <link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	
	<h1 class="title">Product List</h1>
	<!--  <a href>는 URL 경로를 사용 상대경로 절대 경로 사용 가능 -->
	<a href = "./detail?productNum=28">Product Detail</a>
	
	<% List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list"); 
			for(ProductDTO productDTO : ar){
				
			
	
	%>
	
	<h3><%=productDTO.getProductName() %></h3>
	<h3><%=productDTO.getProductJumsu()%></h3>
	
	
	<%} %>
	<hr>
	
	<table class="table1">
		<thead>
			<tr>
				<th>상품명</th><th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto"> <!-- dto는 page영역에 담김 -->
				<tr>
				<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
				<td>${dto.productJumsu}</td>
				<!-- EL에서는 get에서 get을 뺀 앞글자를 소문자로한 것을 사용 -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	
	<h3>${requestScope.list}</h3>
	
</body>
</html>