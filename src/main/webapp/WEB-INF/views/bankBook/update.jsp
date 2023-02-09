<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정 Page</h1>
	<form action="./update" method="post">
		<fieldset>
			<legend>상품 번호</legend>
		 	<input type="text" name="bookNumber" value="${update.bookNumber}" readonly>
		</fieldset>
		<fieldset>
			<legend>이름</legend>
			<input type ="text" name="bookName" value="${update.bookName}"><br>
		</fieldset>
		<fieldset>
		<legend>이자율</legend>
			<input type="text" name="bookRate" value="${update.bookRate}"><br>
		</fieldset>
		<fieldset>
		<legend>판매 여부</legend>
		 		<label for="bs1">판매</label>
		 		<input id="bs1" type="radio" ${update.bookSale eq '1' ? 'checked':''} name="bookSale" value="1">
				<label for="bs2">판매 중단</label>
				<input id="bs2" type="radio" ${update.bookSale eq '0' ? 'checked':''} name="bookSale" value="0"><br> 
			
		</fieldset> 
		<fieldset>
			<legend>판매 여부</legend>
			<select>
				<option value="1" ${update.bookSale eq '1' ? 'selected':''}>판매</option>
				<option value="0" ${update.bookSale eq '0' ? 'selected':''}>판매 중단</option>
			</select>
		</fieldset>
		<fieldset>
		<legend>상세 설명</legend>
		<textarea rows="" cols="" name="bookDetail" >${update.bookDetail}</textarea><br>
	</fieldset>
	<fieldset>
		<button type="submit">전송</button>
	</fieldset>
	</form>
</body>
</html>