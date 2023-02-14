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
		
		<div class="row justify-content-center my-4">
			<h1 class="col-md-7 mb-5">회원수정 페이지</h1>
			<form action="./memberUpdate" method="post">
				
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="name" class="form-label col-sm-2">NAME</label> 
					<div class="col-sm-10">
						<input type="text" id="name" name="name" value="${member.name}">
					</div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="address" class="form-label col-sm-2">ADDRESS</label> 
					<div class="col-sm-10">
						<input type="text" id="address" name="address" value="${member.address}"> 
					</div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="phone" class="form-label col-sm-2">PHONE</label> 
					<div class="col-sm-10">
						<input type="text" id="phone" name="phone" value="${member.phone}">
					</div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<label for="email" class="form-label col-sm-2">EMAIL</label> 
					<div class="col-sm-10">
						<input type="text" id="email" name="email" value="${member.email}">
					</div>
				</div>
				<div class="mb-3 row col-md-7 mx-auto">
					<button class="offset-md-9 col-md-3 btn btn-primary"type="submit">전송</button>
				</div>
			
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>