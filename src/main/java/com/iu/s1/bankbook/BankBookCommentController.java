package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value="/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BbsService bankBookCommentService;
	
	@RequestMapping(value="list" , method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		pager.setPerPage(5L);
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		
		mv.setViewName("common/commentList");
		return mv;
	}
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession httpSession,Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		bankBookCommentDTO.setWriter(memberDTO.getId());
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);
		if(result>0) {
			List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
			mv.addObject("list", ar);
		}
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookCommentService.setBoardDelete(bankBookCommentDTO, null);
		
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookCommentDTO.getContents());
		System.out.println(bankBookCommentDTO.getNum());
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO, ModelAndView mv) throws Exception{
		mv = new ModelAndView();
		
		mv.addObject("dto", bankBookCommentDTO);
		mv.setViewName("common/commentUpdate");
		return mv;
	}
	

}
