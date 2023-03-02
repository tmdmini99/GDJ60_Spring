package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//Controller 진입전
		//return이 true라면 다음 Controller로 진행
		//return이 false라면 Controller로 진행 X
		//return super.preHandle(request, response, handler);
		System.out.println("MemberCheck Interceptor");
		
		Object obj = request.getSession().getAttribute("member");
		if( obj != null) {
			return true;
		}
		System.out.println("로그인 안한 경우");
		// 1. Foward Jsp Interner resolver를 거치지 않음
//				request.setAttribute("result", "권한이 없습니다");
//				request.setAttribute("url", "../member/memberLogin");
//				RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
//				view.forward(request, response);
		//2. Redirect
		
		
		
		response.sendRedirect("../member/memberLogin");
		
		return false;
		
		
		
		
		
		
		
		
//		boolean check = true;
//		if(request.getSession().getServletContext().getAttribute("member") == null) {
//			check = false;
//			response.sendRedirect("../member/memberLogin");
//		}
//		return check;
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//Controller에서 리턴후 DS 전
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//JSP 렌더링 후
		
	}
}
