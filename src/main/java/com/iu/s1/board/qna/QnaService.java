package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	//BoardDAO 사용 가능
	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		
		
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setBoardAdd(bbsDTO);
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	//reply
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		//QnaDTO
		//num : 부모의 글 번호
		//wrtier, title, contents : 답글을 입력한 값
		//ref : null
		//step : null
		//depth : null
		//1. 부모의 정보를 조회
		QnaDTO parent=(QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		//ref : 부모의 ref
		qnaDTO.setRef(parent.getRef());
		//step : 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		//depth: 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. Step update
		int result=qnaDAO.setStepUpdate(parent);
		result=qnaDAO.setReplyAdd(qnaDTO);
		return result;
	}

	
}
