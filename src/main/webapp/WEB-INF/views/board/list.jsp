<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid">
	
	<div class="row my-5">
		<h1> ${boardName}List</h1>
	
	</div>
	
	<div class="row">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>
							<c:catch>
							<!--Notice에는 depth가 없어서 Exception 발생  -->
							<!-- Exception 처리는 catch -->
								<c:forEach begin="1" end="${dto.depth}" varStatus="j">
								--<c:if test="${j.last}"> > </c:if>
								</c:forEach>
							</c:catch>
								<a href="./detail?num=${dto.num}">${dto.title}</a>
						</td>
						<td>
							<c:choose>
								<c:when test="${boardName eq 'notice'}">
										관리자
								</c:when>
								<c:otherwise>
									${dto.writer}
								</c:otherwise>
							</c:choose>
						</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
			<!-- paging -->
		<div class="row">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="1">
			        			<!-- 						==page=1 -->
			        			
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
			        			<span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->
			      			</a>
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    		<li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="#" data-board-page="${i}">${i}</a></li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after eq false ? 'disabled' : ''}"> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
			        			<span aria-hidden="true">&rsaquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		</li>
		  			</ul>
				</nav>
		
			</div>
			<!-- 검색창 -->
			<form class="row g-3" action="./list" method="name" id="searchForm">
				<input type="hidden" name="page" value="1" id="page">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label>
					<select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title" ${pager.kind eq 'title' ? 'selected' : '' }>제목</option>
						<option value="contents" ${pager.kind eq 'contents' ? 'selected' : '' }>내용</option>
						<option value="wrtier" ${pager.kind eq 'writer' ? 'selected' : '' }>작성자</option>
					</select>
				</div>
				<div class="col-auto">
					<label for="Search" class="visually-hidden">Search</label>
					<input type="text" class="form-control" name="search" id="search" placeholder="검색어 입력" value="${pager.search}">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
			<c:if test="${not empty member}">
			
			<c:if test="${boardName eq 'notice' and member.roleDTO.roleName eq 'ADMIN'}">
				<div class="row">				
					<a href="./add">등록</a>
				</div>
			</c:if>
			
			<c:if test="${boardName ne 'notice'}">
				<div class="row">
					<a href="./add">등록</a>
				</div>
			</c:if>
			</c:if>
		
	</div>
</div>


<c:import url="../template/common_js.jsp"></c:import>
<script src="../resources/js/paging.js"></script>
</body>
</html>