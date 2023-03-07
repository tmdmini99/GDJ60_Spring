<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook Detail page</h1>
	
	<c:choose >
		<c:when test="${not empty detail}">
			
			<h2>Number : ${detail.bookNumber}</h2>
			<h2>Title : ${detail.bookName}</h2>
			<h2>Rate :${detail.bookRate}</h2>
			<h2>Sale :${detail.bookSale}</h2>
			<h2>Detail :${detail.bookDetail}</h2>
			startNum : ${pager.startRow}
			<div>
				<!-- bankBookDTO에 있는 멤버 변수 bankBOokImgDTO안에 있는 fileName을 꺼내옴 -->
				<c:if test="${not empty detail.bankBookImgDTO }">
				<img alt="이미지없음" src="../resources/upload/bankBook/${detail.bankBookImgDTO.fileName}">
				</c:if>
			</div>
			
			<a href="./delete?bookNumber=${detail.bookNumber}">상품 삭제</a>
			<a href="./update?bookNumber=${detail.bookNumber}">상품 수정</a>
		</c:when>
		<c:otherwise>해당 상품이 없습니다</c:otherwise>
	
	</c:choose>
	
	
	
	
	<a href="./list">목록으로</a>

	<div class="my-5" id="comment">


	</div>
	

	<div id="di">
	
	  <div class="mb-3">	
		<!-- <input type="hidden" value="${detail.bookNumber}" id="inp1">
		<input type="hidden" value="${member.id}" id="inp2"> -->
		<textarea class="form-control " id="inp3" rows="3"></textarea>
	  </div>
	  <div class="mb-3">
		<button type="button" class="btn btn-primary" id="btn" data-book-bookNumber="${detail.bookNumber}">댓글등록</button>


	  </div>
	  
	</div>

	<!-- Update Form Modal -->
	<!-- Button trigger modal -->
	
	
	<!-- Modal -->
	<div class="modal fade" id="contentsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="form-floating">
					<textarea class="form-control" placeholder="Leave a comment here" id="contents" style="height: 100px"></textarea>
					<label for="contents">Comments</label>
				  </div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="closeModal">Cancel</button>
			<button type="button" class="btn btn-primary"  id="contentsConfirm">확인</button>
			</div>
		</div>
		</div>
	</div>
<!-- Test 후 삭제할 영역 -->
<div class="my-5">
	<button type="button" id="b1">BUTTON</button>
	<input type="text" id="t1">
	<div class="my-5">
		
		<input type="checkbox" class="ch" name="ch" id="" value="v1">
		<input type="checkbox" class="ch" name="ch" id="" value="v2">
		<input type="checkbox" class="ch" name="ch" id="" value="v3">
		<input type="checkbox" class="ch" name="ch" id="" value="v4">
	</div>
</div>

<script src="/resources/js/bankBookReply.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>