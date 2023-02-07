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
	
	@RequestMapping(value="memberJoin" ,method=RequestMethod.GET)
	public void setMemberAdd() throws Exception{
		
	}
	@RequestMapping(value="memberJoin" ,method=RequestMethod.POST)
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
	
	
	
	@RequestMapping(value="memberLogin")
	public void getMemberLogin() {
		
		System.out.println("MemberLogin");
	}
	
	@RequestMapping(value="memberPage")
	public ModelAndView getMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
}
