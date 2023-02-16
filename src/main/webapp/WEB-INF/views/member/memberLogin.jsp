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
			<h1 class="col-md-7 my-3">MemberLogin Page</h1>
			
			<form class="col-md-7 my-4" action="./memberLogin" method="post">
				<div class="mb-3 col-md-7">
					<label for="id" class="form-label">ID</label> 
					<input class="form-control" id="id" type="text" name="id" placeholder="ID 입력">
				</div>
				<div class="mb-3 col-md-7 my-4">
					<label for="pw" class="form-label">Password</label> 
					<input class="form-control" id="pw" type="password" name="pw" placeholder="PW 입력">
				</div>
				<div class="mb-3 col-md-7">
					<button class="btn btn-primary offset-md-9 col-md-3" type="submit">전송</button>
				</div>
				
			</form>
		</div>
	</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>