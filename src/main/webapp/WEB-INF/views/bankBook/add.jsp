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
		<fieldset>
		<legend>상품명</legend>
			<input type ="text" name="bookName" placeholder="제품명 입력"><br>
		</fieldset>
		<fieldset>
		<legend>이자율</legend>
			<input type="text" name="bookRate"><br>
		</fieldset>
		<fieldset>
		<legend>상세정보</legend>
		<textarea rows="5" cols="5" name="bookDetail"></textarea><br>
		</fieldset>
		<fieldset>
		<legend>판매 여부</legend>
		<label for="bs1">판매</label>
		<input id="bs1" type="radio" name="bookSale" value="1">
		<label for="bs2">판매 중단</label>
		<input id="bs2" type="radio" name="bookSale" value="0"><br>
		</fieldset>
		<fieldset>
			<button type="submit">전송</button>
		</fieldset>
	</form>
</body>
</html>