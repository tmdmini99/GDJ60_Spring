<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정 Page</h1>
	<form action="./update" method="post">
		상품 번호 :<input type="text" name="bookNumber" value="${update.bookNumber}" readonly>
		이름: <input type ="text" name="bookName" value="${update.bookName}"><br>
		이자율 : <input type="text" name="bookRate" value="${update.bookRate}"><br>
		<!-- 판매<input type="radio" name="bookSale" value="1">
		판매 불가<input type="radio" name="bookSale" value="0"><br> -->
		판매 : <input type="text" name="bookSale" value="${update.bookSale}">
		상세 설명<textarea rows="" cols="" name="bookDetail" >${update.bookDetail}</textarea><br>
	<button type="submit">전송</button>
	</form>
</body>
</html>