package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	//BbsService 사용 가능
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		mv.setViewName("./board/list");
		mv.addObject("list", ar);
		return mv;
	}
	@GetMapping("add")
	public ModelAndView setBoardAdd() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		return mv;
		
	}
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO,MultipartFile [] files,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO,files,session);
		
		String name ="등록 실패";
		
		if(result>0) {
			name = "글이 등록되었습니다";
		}
		
		mv.addObject("url", "./list");
		mv.addObject("result", name);
		mv.setViewName("common/result");
		return mv;
		
	}
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO=qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		
		mv.setViewName("./board/detail");
		return mv;
	}
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/reply");
		return mv;
	}
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result=qnaService.setReplyAdd(qnaDTO);
		
		String name ="등록 실패";
		
		if(result>0) {
			name = "글이 등록되었습니다";
		}
		mv.addObject("url","./detail?num="+qnaDTO.getNum());
		mv.addObject("result", name);
		mv.setViewName("common/result");
		return mv;
	}
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardDelete(bbsDTO,session);
		String name ="삭제 실패";
		
		if(result>0) {
			name = "글이 삭제되었습니다";
		}
		
		mv.addObject("url","./list");
		mv.addObject("result", name);
		mv.setViewName("common/result");
		return mv;
	}
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileDTO=qnaService.getBoardFileDetail(boardFileDTO);
		System.out.println("여기는 Con");
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		return mv;
	}
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO=qnaService.getBoardDetail(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO,BoardFileDTO boardFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO=qnaService.getBoardDetail(boardDTO);
		return mv;
	}
	
	
	
}
