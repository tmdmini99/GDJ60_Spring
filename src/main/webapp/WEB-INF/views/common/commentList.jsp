<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



		<table>
			<thead>
				<tr>
				<th>
					작성자
				</th>
				<th>
					내용
				</th>
				<th>
					작성시간
				</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
				</tr>
					</c:forEach>
				<tr></tr>
				<tr></tr>
			</tbody>
		</table>
		
		<div class="row" id="div">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<button type="button" class="page-link pageFirst" aria-label="Previous">
								  <!-- 						==page=1 -->
								<span aria-hidden="true">&laquo;</span>
							</button>
			        			
			        			
			      			
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<button type="button" class="page-link pageBefore" data-page-before="${pager.startNum-1}" aria-label="Previous" >
								  <span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->

							</button>
			      			
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							<li class="page-item">
								<button type="button" class="page-link ${pager.page eq i ? 'active' : '' } btns" data-page="${i}">${i}</button>
								
							</li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after eq false ? 'disabled' : ''}"> <!--  -->
							<button type="button" class="page-link pageAfter" data-page-after="${pager.lastNum+1}" aria-label="Next">
								<span aria-hidden="true">&rsaquo;</span>
							</button>
							
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<button type="button" class="page-link pageLast"  data-page-total="${pager.totalPage}" aria-label="Next">

								  <span aria-hidden="true">&raquo;</span>

							</button>
							
			      			
			    		</li>
		  			</ul>
				</nav>
		
			</div>
			
			
			
			
		
		
		
	