package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin")
	public String getMemberJoin() {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("tmd");
		memberDTO.setPw("1234");
		memberDTO.setName("승민");
		memberDTO.setAddress("주소");
		memberDTO.setPhone("0011");
		memberDTO.setEmail("email@gmail.com");
		
		try {
			int a = memberService.memberJoin(memberDTO);
			System.out.println(a>0);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Member Join");
		return "member/memberJoin";
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
