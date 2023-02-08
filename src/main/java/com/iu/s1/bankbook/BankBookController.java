package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//list
	@RequestMapping(value = "list" , method=RequestMethod.GET)
	public ModelAndView getBankBookList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.getBankBookList();
		mv.addObject("list", ar);
		mv.setViewName("/bankBook/list");
		return mv;
		
	}
	@RequestMapping(value="detail" , method=RequestMethod.GET)
	public ModelAndView getBankDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO=bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.addObject("detail", bankBookDTO);
		mv.setViewName("/bankBook/detail");
		return mv;
	}
	@RequestMapping(value="add" , method=RequestMethod.GET)
	public ModelAndView setBankBookAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankBook/add");
		return mv;
	}
	@RequestMapping(value="add" , method=RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int a  = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		bankBookDTO=bankBookService.getBankBookDetail(bankBookDTO);
		mv.addObject("update", bankBookDTO);
		mv.setViewName("bankBook/update");
		return mv;
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO,ModelAndView mv) throws Exception{
		
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		System.out.println(result == 1);
		mv.setViewName("redirect:./list");
		return mv;
	}
}
