package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	//BoardDAO 사용 가능
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	
	
	
	
	public int setBoardUpdate(BbsDTO bbsDTO, HttpSession session, MultipartFile[] multipartFiles, Long[] fileNums)
			throws Exception {
		//qna Update
		int result =qnaDAO.setBoardUpdate(bbsDTO);
		
			
		//qnaFiles Delete
		if(fileNums !=null) {
		for(Long fileNum : fileNums) {
			qnaDAO.setBoardFileDelete(fileNum);
		}
		}
		String realPath = session.getServletContext().getRealPath("/resources/upload/qna/");
		
		
		//qnaFiles Insert
		for(MultipartFile f : multipartFiles) {
			if(f.isEmpty()) {
				continue;
			}
			String name = fileManager.fileSave(f, realPath);
			QnaImgDTO qnaImgDTO = new QnaImgDTO();
			qnaImgDTO.setFileName(name);
			qnaImgDTO.setNum(bbsDTO.getNum());
			qnaImgDTO.setOriName(f.getOriginalFilename());
			result = qnaDAO.setBoardFileAdd(qnaImgDTO);
			
		}
		return result;
	}

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
	public int setBoardAdd(BbsDTO bbsDTO,MultipartFile [] files,HttpSession session) throws Exception {
		// file HDD에 저장

		
		//DB INSERT
		String realPath = session.getServletContext().getRealPath("/resources/upload/qna/");
		
		int a=qnaDAO.setBoardAdd(bbsDTO);
		System.out.println(bbsDTO.getNum());
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			String name = fileManager.fileSave(f, realPath);
			QnaImgDTO qnaImgDTO = new QnaImgDTO();
			qnaImgDTO.setFileName(name);
			qnaImgDTO.setNum(bbsDTO.getNum());
			qnaImgDTO.setOriName(f.getOriginalFilename());
			a = qnaDAO.setBoardFileAdd(qnaImgDTO);
			
		}
		return a;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result=qnaDAO.setBoardDelete(bbsDTO);
		
		if(result>0) {
			String realPath=session.getServletContext().getRealPath("resources/upload/qna");
			
			for(BoardFileDTO boardFileDTO : ar) {
			fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			
		}
		return result;
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
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardFileDetail(boardFileDTO);
	}
	public int setboardFileDelete(Long fileNum) throws Exception{
		return qnaDAO.setBoardFileDelete(fileNum);
	}

	
}
