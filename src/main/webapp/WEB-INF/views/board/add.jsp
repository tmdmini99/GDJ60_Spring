<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>


	<c:if test="${not empty member}">
	<div class="container-fluid">
		
			<div class="row mt-4 my-5">
				<h1 class="title mx-auto text-center  col-md-7">${boardName} Page</h1>
			</div>
			<div class="row justify-content-center">
			<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="writer" class="form-label">작성자</label> 
					<input class="form-control" id="writer" type="text" name="writer" value="${member.id}" readonly>
				</div>
				<div class="mb-3">
					<label for="title" class="form-label">제목</label> 
					<input class="form-control" id="title" type="text" name="title" placeholder="제목입력">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">내용</label>
					<textarea class="form-control" id="contents" name="contents" rows="3" placeholder="내용 입력"></textarea>
					
				</div>
				 <div id="fileList">
					<!-- <div class="mb-3">
						<label for="files" class="form-label">Image</label>
						<input type="file" class="form-control" id="files" name="files">
					</div>  -->
					
					
					<button type="button" id="btn">add</button>
					
				</div> 
				
				
				<div class="mb-3">
					<button type="submit" class=" btn btn-info text-center offset-md-9 col-md-3 ">글쓰기</button>
				</div>
			</form>
			</div>
		
	</div>
	</c:if>
	<script src="../resources/js/fileManager.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
	<script>
		setMax(5);
		setName('addfiles');
		$("#contents").summernote();
	</script>
</body>
</html>