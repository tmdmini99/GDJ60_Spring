<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Product Add Page</h1>
<form action="./productAdd" method="post"> <!-- URL -->
	상품명: <input type="text" name="productName"> <!-- name은 파라미터의 이름으로 Controller에서 받는 파라미터 값 -->
	설명: <textarea name="productDetail"></textarea>
	
	<button type="submit">전송</button>
	

</form>
</body>
</html>