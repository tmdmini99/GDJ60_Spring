<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Add Page</h1>
	
	<form action="./add" method="post"><br>
		
		
		이름: <input type ="text" name="bookName"><br>
		이자율 : <input type="text" name="bookRate"><br>
		판매<input type="radio" name="bookSale" value="1">
		판매 불가<input type="radio" name="bookSale" value="0"><br>
		상세 설명<textarea rows="5" cols="5" name="bookDetail"></textarea><br>
	<button type="submit">전송</button>
	</form>
</body>
</html>