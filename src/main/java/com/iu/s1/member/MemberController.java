package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	
	
	@Autowired
	private MemberService memberService;
	
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
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("MemberLogin");
		mv.setViewName("member/memberLogin");
		return mv;
	}
	@RequestMapping(value="memberLogin" ,method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO=memberService.getMemberLogin(memberDTO);
		if(memberDTO !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
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
