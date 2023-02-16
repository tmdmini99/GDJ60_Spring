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
	<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="title">Product List</h1>
	<!--  <a href>는 URL 경로를 사용 상대경로 절대 경로 사용 가능 -->
	<a href = "./detail?productNum=28">Product Detail</a>
	

	<div class="row col-md-7 mx-auto">
	
	<table class="table2">
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
	<div class="mx-auto offset-md-6 col-md-6">
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}">이전</a></li>
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    
	    <li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
	    </c:forEach>
	    <li class="page-item"><a class="page-link" href="./list?page=${pager.lastNum+1}">다음</a></li>
	  </ul>
	</nav>
	</div>
	<div class="row">
		<form class="row g-3" action="./list" method="get">
		  <div class="col-auto">
		    <label for="kind" class="visually-hidden">Kind</label>
		    <select class="form-select" name="kind" id="kind" aria-label="Default select example">
  				<option value="title">제품 이름</option>
  				<option value="contents">제품 설명</option>
  				
			</select>
		  </div>
		  <div class="col-auto">
		    <label for="search" class="visually-hidden">search</label>
		    <input type="text" name="search" class="form-control" id="search" placeholder="검색">
		  </div>
		  <div class="col-auto">
		    <button type="submit" class="btn btn-primary mb-3">검색</button>
		  </div>
		</form>
	
	</div>
	
	
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	</div>
	
	
	
	
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>