<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
	.redResult{
		color: red;
	}
	.blueResult{
		color: blue;
	}
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>


	<div class="container-fluid ">
		<div class="row col-md-7 mx-auto my-3">
			<h1 class="text-center mx-auto mb-5 border-bottom border-dark border-2 pb-2">MemberJoin Page</h1>
			
			<form action="./memberAdd" method="post" id="frm">
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="id" class="form-label ">ID</label> 
					<input type="text" id="id" name="id" placeholder="ID 입력">
					
					<div id="idResult"></div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="pw" class="form-label">PW</label> 
					<input type="password" id="pw" name="pw">
					
					<div id="pwResult"></div>
				</div> 
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="pw1" class="form-label">PW확인</label> 
					<input type="password" id="pw1" name="pw1">
					
					<div id="pwResultCheck"></div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="name" class="form-label">NAME</label> 
					<input type="text" id="name1" name="name">
					
					<div id="nameResult"></div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="address" class="form-label">ADDRESS</label> 
					<input type="text" id="address" name="address"> 
					
					<div id="addressResult"></div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="phone" class="form-label">PHONE</label> 
					<input type="text" id="phone" name="phone">
					
					<p id="phoneResult"></p>
				</div>
				<div class="mb-3 row col-md-7 mx-auto" >
					<label for="email" class="form-label">EMAIL</label> 
					<input type="text" id="email" name="email">
					
					<div id="emailResult"></div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<button id="btn" class="offset-md-9 col-md-3" type="button">전송</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/memberAdd.js"></script>
</body>
</html>