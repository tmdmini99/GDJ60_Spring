<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Member Join Page</h1>
 <form action="./memberJoin" method="post"> <br>
 ID : <input type="text" name="id"><br>
 PASSWORD : <input type="password" name="pw"><br>
 NAME : <input type="text" name="name"><br>
 ADDRESS : <input type="text" name="address"><br>
 PHONE : <select name="phone">
 	<option>010</option>
 	<option>011</option>
 	<option>017</option>
 </select> -
 <input type="text" name="phone" >-<input type="text" name="phone" >
 <br>
 EMAIL : <input type="text" name="email">@
 <select name="email">
 	<option>naver.com</option>
 	<option>gmail.com</option>
 	<option>nate.com</option>
 </select><br>
 
 <button type="submit">전송</button>
 </form>
</body>
</html>