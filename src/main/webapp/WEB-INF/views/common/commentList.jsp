<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



		<table>
			<thead>
				<tr>
				<th>
					내용
				</th>
				<th>
					작성자
				</th>
				<th>
					작성시간
				</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td id="contents${dto.num}">${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>
						<c:if test="${dto.writer eq member.id}">
							<button class="btn btn-danger dt" data-delete="${dto.num}">
								DELETE
							</button>
						</c:if>
					</td>
					<td>
						<c:if test="${dto.writer eq member.id}">
							<button class="btn btn-info up" data-update="${dto.num}" data-contents="${dto.contents}" data-bs-toggle="modal" data-bs-target="#contentsModal">
								UPDATE
							</button>
						</c:if>
					</td>
				</tr>
					</c:forEach>
				<tr></tr>
				<tr></tr>
			</tbody>
		</table>
		
		<!-- <div class="row" id="div">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<button type="button" class="page-link pageFirst" aria-label="Previous">
								 
								<span aria-hidden="true">&laquo;</span>
							</button>
			        			
			        			
			      			
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<button type="button" class="page-link pageBefore" data-page-before="${pager.startNum-1}" aria-label="Previous" >
								  <span aria-hidden="true">&lsaquo;</span> 

							</button>
			      			
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							<li class="page-item">
								<button type="button" class="page-link ${pager.page eq i ? 'active' : '' } btns" data-page="${i}">${i}</button>
								
							</li>
			    		</c:forEach>
			    		
			    		<li class="page-item ${pager.after eq false ? 'disabled' : ''}"> 
							<button type="button" class="page-link pageAfter" data-page-after="${pager.lastNum+1}" aria-label="Next">
								<span aria-hidden="true">&rsaquo;</span>
							</button>
							
			    		</li>
			    		<li class="page-item "> 
			      			<button type="button" class="page-link pageLast"  data-page-total="${pager.totalPage}" aria-label="Next">

								  <span aria-hidden="true">&raquo;</span>

							</button>
							
			      			
			    		</li>
		  			</ul>
				</nav>
		
			</div> -->

			<div class="row">
				<nav aria-label="Page navigation example">
		 			<ul class="pagination">
			    		<li class="page-item ">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="1">
			        			<!-- 						==page=1 -->
			        			
			        			<span aria-hidden="true">&laquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item ${pager.before ? 'disabled' : ''}">
			      			<a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
			        			<span aria-hidden="true">&lsaquo;</span> <!--lsaquo는 꺽쇠 하나 laquo는 꺽쇠 두개  -->
			      			</a>
			    		</li>
			    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    		<li class="page-item"><a class="page-link ${pager.page eq i ? 'active' : '' }" href="#" data-board-page="${i}">${i}</a></li>
			    		</c:forEach>
			    		<!-- &gt = <꺽쇠를 표현 &lt는 >꺽쇠를 표현 -->
			    		<li class="page-item ${pager.after eq false ? 'disabled' : ''}"> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
			        			<span aria-hidden="true">&rsaquo;</span>
			      			</a>
			    		</li>
			    		<li class="page-item "> <!--  -->
			      			<a class="page-link " href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
			        			<span aria-hidden="true">&raquo;</span>
			      			</a>
			    		</li>
		  			</ul>
				</nav>
		
			</div>



			
			
			
			
		
		
		
	