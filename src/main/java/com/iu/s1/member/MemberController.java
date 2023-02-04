package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin" ,method=RequestMethod.GET)
	public void setMemberJoin() throws Exception{
		
		
	}
	@RequestMapping(value="memberJoin" ,method=RequestMethod.POST)
	public String setMemberJoin(MemberDTO memberDTO) throws Exception{
		int a = memberService.setAddMember(memberDTO);
		System.out.println(a == 1);
		return "redirect:./list";
	}
	@RequestMapping(value="list")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception{
		List<MemberDTO> ar=memberService.getMemberList();
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		return mv;
		
	}
	
}
