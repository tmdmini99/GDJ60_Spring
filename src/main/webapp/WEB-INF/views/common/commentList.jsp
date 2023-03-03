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
		
		
		
	