package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean check=memberService.getMemberIdCheck(memberDTO);
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value="memberAgree", method =RequestMethod.GET)
	public void setMemberAgree() throws Exception{
		
	}
	
	
	
	@RequestMapping(value="memberAdd" ,method=RequestMethod.GET)
	public void setMemberAdd() throws Exception{
		
	}
	@RequestMapping(value="memberAdd" ,method=RequestMethod.POST)
	public String setMemberAdd(MemberDTO memberDTO) throws Exception{
		int a= memberService.setMemberAdd(memberDTO);
		
		return "redirect:/";
	}
	
	
	
	
	@RequestMapping(value="memberLogin" ,method = RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		
//		Cookie [] cookies=request.getCookies();
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("------");
//			if(cookie.getName().equals("rememberId")) {
//				mv.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		System.out.println("MemberLogin");
		
		mv.setViewName("member/memberLogin");
		return mv;
	}
	@RequestMapping(value="memberLogin" ,method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request,String remember,HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Remember :"+remember);
		if(remember !=null&&remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7);//초단위
			
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			
			cookie.setMaxAge(0);//-1은 영구 저장
			response.addCookie(cookie);
		}
		memberDTO=memberService.getMemberLogin(memberDTO);
//		if(memberDTO !=null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);
//		}
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberPage")
	public ModelAndView getMemberPage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO=memberService.getMemberPage(memberDTO);
		mv.addObject("memberPage",memberDTO);
		
		mv.setViewName("member/memberPage");
		return mv;
	}
	@RequestMapping(value="memberLogout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	@RequestMapping(value="memberUpdate" ,method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO=memberService.getMemberPage((MemberDTO)session.getAttribute("member"));
		mv.addObject("memberDTO", memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	@RequestMapping(value="memberUpdate" ,method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO,HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result=memberService.setMemberUpdate(memberDTO);
//		if(result >0) {
//			session.setAttribute("member", sessionMemberDTO);
//		}
		
		mv.setViewName("redirect:./memberPage");
		return mv;
	}
	
	
}
