<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<div class="hyperLink">
	<a href = "./product/list?num=1&num=2&num=3" >ProductList</a>
	<a href = "/WEB-INF/views/product/list" >ProductList</a>
	<a href = "/bankBook/list" >BankBookList</a>
	<a href="./bankBook/list" >BankBookList</a>
</div>
<img alt="iu이미지1" src="/resources/images/iu.jpg">

<img alt="iu이미지2" src="./resources/images/iu2.jpg">
<!--URL주소 기준으로 파일 위치를 정함 ./resources/images/iu2.jpg는 파일 위치를 보고 봐야함 -->

<iframe width="560" height="315" src="https://www.youtube.com/embed/N1Oge1iooPw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
