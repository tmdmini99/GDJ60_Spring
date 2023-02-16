<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail page</h1>
	
	<c:choose >
		<c:when test="${not empty detail}">
			
			<h2>Number : ${detail.bookNumber}</h2>
			<h2>Title : ${detail.bookName}</h2>
			<h2>Rate :${detail.bookRate}</h2>
			<h2>Sale :${detail.bookSale}</h2>
			<h2>Detail :${detail.bookDetail}</h2>
			<a href="./delete?bookNumber=${detail.bookNumber}">상품 삭제</a>
			<a href="./update?bookNumber=${detail.bookNumber}">상품 수정</a>
		</c:when>
		<c:otherwise>해당 상품이 없습니다</c:otherwise>
	
	</c:choose>
	<a href="./list">목록으로</a>
</body>
</html>