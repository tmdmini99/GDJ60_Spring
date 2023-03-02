package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;
import com.iu.s1.member.RoleDTO;


public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	//Role이 Admin이면 통과
	//아니면 index(home.jsp)로 보냄
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO !=null) {
			if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN")) {
			
			return true;
			}
		}
		//foward
		
		request.setAttribute("result", "되겠냐?");
		request.setAttribute("url", "../");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		
		//Redirect
//		response.sendRedirect("/");
		return false;
	}
	
	
}
