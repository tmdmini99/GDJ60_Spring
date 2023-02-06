<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1>Member List Page</h1>

<c:forEach items="${list}" var="dto">
<h2>${dto.id}</h2>
<h2>${dto.pw}</h2>
<h2>${dto.name}</h2>
<h2>${dto.address}</h2>
<h2>${dto.phone}</h2>
<h2>${dto.email}</h2>
</c:forEach>
	<a class="btn btn-danger" href="./memberJoin">회원가입</a>
	
</body>
</html>