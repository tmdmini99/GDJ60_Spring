<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<div class="row mb-4">
			<h1 class="title col-md-7 mx-auto text-center border-bottom border-dark pb-4">BankBook List page</h1>
		</div>
		<div class="row col-md-7 mx-auto">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>이자율</th>
					<th>판매여부</th>
				</tr>
				</thead>
				<tbody class="table-group-divider">
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
			
			<!-- Paging -->
			<div class="row">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<a class="page-link" href="./list?page" aria-label="Previous">
			        			<!-- 						==page=1 -->
			        			
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
			        			<span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->
			      			</a>
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    		<li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after eq false ? 'disabled' : ''}"> <!--  -->
			      			<a class="page-link " href="./list?page=${pager.lastNum+1}"  aria-label="Next">
			        			<span aria-hidden="true">&rsaquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<a class="page-link " href="./list?page=${pager.totalPage}"  aria-label="Next">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		</li>
		  			</ul>
				</nav>
		
			</div>
			<!-- 검색창 -->
			<form class="row g-3" action="./list" method="name">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label>
					<select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title">상품명</option>
						<option value="contents">상품내용</option>
						
					</select>
				</div>
				<div class="col-auto">
					<label for="Search" class="visually-hidden">Search</label>
					<input type="text" class="form-control" name="search" id="search" placeholder="검색어 입력">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
			
			
			
			
			
			
			
			
		</div>
		
		
		<div class="row col-md-7 mx-auto">
			<a href="./add" class ="btn btn-primary col-2">상품 등록</a>
		</div>
		
	</div>
	
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>