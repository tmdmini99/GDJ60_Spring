<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="title">BankBook List page</h1>
	<div class="image">
		<img  alt="" src="../resources/images/iu.jpg">
	</div>	
	<table class="table2">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
				<td class="tb1_td td1 td">${dto.bookRate}</td>
				<td class="tb1_td td"><!-- <c:if test="${dto.bookSale eq 1}">판매중</c:if>
						<c:if test="${dto.bookSale eq 0}">판매중단</c:if> -->
						<!-- EL if문은 c:if로 두가지를 쓰거나 
							choose를 사용하여 if, else if문을 대체
							otherwise가 else if문을 대체
						 -->
						<c:choose>
							<c:when test="${dto.bookSale eq 1}">판매중</c:when>
							<c:otherwise>판매중단</c:otherwise>

							</c:choose>						
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="./add">상품 등록</a>
</body>
</html>