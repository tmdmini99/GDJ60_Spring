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
		<div class="row">
			<div class="row mt-4 my-5">
				<h1 class="title col-md-7 mx-auto text-center ">BankBook Add
					Page</h1>
			</div>
			<form action="./add" method="post">
				<br>
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="bookName" class="form-label">제품명</label> 
					<input class="form-control" id="bookName" type="text" name="bookName" placeholder="제품명 입력">
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="bookRate" class="form-label">이자율</label> 
					<input class="form-control" id="bookRate" type="text" name="bookRate" placeholder="이자율 입력">
				</div>
				<div class="mb-3 col-md-7 mx-auto">
					<label for="bookDetail" class="form-label">상세설명</label>
					<textarea class="form-control" id="bookDetail" name="bookDetail"
						rows="3"></textarea>
					<br>
				</div>
				<div class="mb-3 col-md-7 mx-auto">
					<label for="bookDetail" class="form-label">판매여부</label>
				</div>
				<div class="form-check col-md-7 mx-auto">
					<label class="form-check-label" for="bs1">판매</label> <input
						class="form-check-input" id="bs1" type="radio" name="bookSale"
						value="1">
				</div>
				<div class="form-check mb-3 col-md-7 mx-auto">
					<label class="form-check-label" for="bs2">판매 중단</label> <input
						class="form-check-input" id="bs2" type="radio" name="bookSale"
						value="0">
				</div>
				<div class="row mx-auto col-md-7 mb-3">
					<button type="submit"
						class="row btn btn-info text-center offset-md-9 col-md-3 ">전송</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>