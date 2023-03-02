package com.iu.s1.qna;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.board.qna.QnaDTO;
import com.iu.s1.util.Pager;

public class QnaTest extends MyTestCase{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
//	public void Qtest() throws Exception{
//		Pager pager = new Pager();
//		pager.makeRow();
//		List<BbsDTO> ar=qnaDAO.getBoardList(pager);	
//		
//		assertNotEquals(0, ar);
//	}
//	
	//@Test
	public void Qtest2() throws Exception{
		Pager pager = new Pager();
		long a = qnaDAO.getTotalCount(pager);
		assertNotEquals(0, a);
	}
	//@Test
	public void Qtest3() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("adfa");
		qnaDTO.setContents("내용");
		qnaDTO.setWriter("rlaxogus");
		int a = qnaDAO.setBoardAdd(qnaDTO);
		assertNotEquals(0, a);
	}
	
	
	

}
