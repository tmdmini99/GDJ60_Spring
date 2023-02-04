<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h3>Hello</h3>
	
	<c:forEach items="${list}" var="dto">
	<h2>${dto.productNum}</h2>
	<h2><a href="./detail?productNum=${dto.productNum}">${dto.productName}</a></h2> <!-- a 링크는 URL을 입력 -->
	</c:forEach>
	
	<a class="btn btn-danger" href="./productAdd">상품 등록</a>
</body>
</html>