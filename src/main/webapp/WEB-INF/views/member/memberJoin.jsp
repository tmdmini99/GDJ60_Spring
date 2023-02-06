<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberJoin Page</h1>

	<form action="./memberJoin" method="post"><br>
	ID : <input type="text" name="id"><br>
	PW : <input type="password" name="pw"><br>
	NAME : <input type="text" name="name"><br>
	ADDRESS : <input type="text" name="address"><br>
	PHONE : <input type="text" name="phone"><br>
	EMAIL : <input type="text" name="email"><br>
	
	<button type="submit">전송</button>
	</form>
	
</body>
</html>