<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>앙</title>
</head>
<body>
	<h1>Product Add</h1>
	<div class="col-6">
		<form action="./productAdd" method="post"> <!-- URL 주소를 적어야함 -->
			상품명 : <input type="text" name="productName" value="test"> <br>
			
			상품 정보 : <textarea name="productDetail" rows="" cols=""></textarea> <br>
		
			<button type="submit">전송버튼</button><br>
		</form>
	
	</div>
</body>
</html>