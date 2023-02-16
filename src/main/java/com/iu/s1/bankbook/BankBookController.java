package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//list
	@RequestMapping(value = "list" , method=RequestMethod.GET)
	public ModelAndView getBankBookList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.getBankBookList(pager);
		
		//자바의 특성을 이용하여 mv.addObject("pager",pager); 에서 따로 선언하지 않아도 매개변수로 가져온 값에 저장하여 그 값을 다시 내보냄
		//pager의 주소값을 service로 넘겨 주고 그 주소값의 값을 바꾼거기 때문에 다시 보내주면 그 주소값이 넘어가서 바뀐값을 출력
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("/bankBook/list");
		return mv;
		
	}
	@RequestMapping(value="detail" , method=RequestMethod.GET)
	public ModelAndView getBankDetail(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
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
		//mv.setViewName("redirect:./detail?bookNumber="+bankBookDTO.getBookNumber());
		return mv;
	}
}
