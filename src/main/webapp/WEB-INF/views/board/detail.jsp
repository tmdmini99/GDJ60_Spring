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
	<div class="row">
	 <h3>${dto.title}</h3>
	 <h3>${dto.writer}</h3>
	 <p>${dto.contents}</p>
	 
	 <c:forEach items="${dto.boardFileDTOs}" var="files">
	 
	 <a href="./fileDown?fileNum=${files.fileNum}">${files.oriName}</a>
	 
	 
	 </c:forEach>
	
	
	
	<c:if test="${boardName ne 'notice'}">	
	<a href="./reply?num=${dto.num}" class="btn btn-info">답글</a>
	</c:if>
	
	
	<%-- <c:if test="${member.id eq dto.writer}"> --%>
	<div>
		<form action="./update" id="frm">
			<input type="hidden" name="num" value="${dto.num}">
			<button id="update" type="submit" class="btn btn-primary">update</button>
			<button id="delete" type="button" class="btn btn-info">delete</button>
			
	
		</form>
	</div>
	<%-- </c:if> --%>
	
	</div>
</div>

<script type="text/javascript" src="../resources/js/boardForm.js" ></script>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>