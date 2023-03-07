<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
			<div class="row mt-4 my-5">
				<h1 class="title mx-auto text-center  col-md-7">BankBook AddPage</h1>
			</div>
			<div class="row justify-content-center">
			<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="bookName" class="form-label">제품명</label> 
					<input class="form-control" id="bookName" type="text" name="bookName" placeholder="제품명 입력">
				</div>
				<div class="mb-3">
					<label for="bookRate" class="form-label">이자율</label> 
					<input class="form-control" id="bookRate" type="text" name="bookRate" placeholder="이자율 입력">
				</div>
				<div class="mb-3">
					<label for="bookDetail" class="form-label">상세설명</label>
					<textarea class="form-control" id="bookDetail" name="bookDetail"
						rows="3"></textarea>
					
				</div>
				<div id="fileList">
					<!-- <div class="mb-3">
						<label for="files" class="form-label">Image</label>
						<input type="file" class="form-control" id="files" name="pic">
					</div> -->
					
					<button type="button" id="btn">add</button>
					
				</div>
				<div class="mb-3">
					<label for="bookDetail" class="form-label">판매여부</label>
				</div>
				<div class="form-check">
					<label class="form-check-label" for="bs1">판매</label> <input
						class="form-check-input" id="bs1" checked type="radio" name="bookSale"
						value="1">
				</div>
				<div class="form-check">
					<label class="form-check-label" for="bs2">판매 중단</label> <input
						class="form-check-input" id="bs2" type="radio" name="bookSale"
						value="0">
				</div>
				<div class="mb-3">
					<button type="submit" class=" btn btn-info text-center offset-md-9 col-md-3 ">전송</button>
				</div>
			</form>
			</div>
		
	</div>
	<script src="../resources/js/fileManager.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
	<script>
		setMax(3);
		
	</script>
</body>
</html>