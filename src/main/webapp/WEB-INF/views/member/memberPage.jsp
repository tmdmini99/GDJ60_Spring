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
	<h1 class="col-md-7 my-3">My Page</h1>
	
	ID: ${memberPage.id} <br>
	NAME: ${memberPage.name} <br>
	ADDRESS: ${memberPage.address} <br>
	PHONE: ${memberPage.phone} <br>
	EMAIL: ${memberPage.email} <br>
	
	
	<a href="./memberUpdate" class="btn btn-info">정보 수정</a>
	</div>
</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>