package com.iu.s1.member;

import java.util.List;

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
	
	@RequestMapping(value="memberAdd" ,method=RequestMethod.GET)
	public void setMemberAdd() throws Exception{
		
	}
	@RequestMapping(value="memberAdd" ,method=RequestMethod.POST)
	public String setMemberAdd(MemberDTO memberDTO) throws Exception{
		int a= memberService.setMemberAdd(memberDTO);
		System.out.println(a == 1);
		return "redirect:./list";
	}
	@RequestMapping(value="list")
	public String getMemberList(Model model) throws Exception{
		List<MemberDTO> ar = memberService.getMemberList();
		model.addAttribute("list", ar);
		return "member/memberList";
		
	}
	
	
	
	@RequestMapping(value="memberLogin" ,method = RequestMethod.GET)
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("MemberLogin");
		mv.setViewName("member/memberLogin");
		return mv;
	}
	@RequestMapping(value="memberLogin" ,method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberService.getMemberLogin(memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberPage")
	public ModelAndView getMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	
}
