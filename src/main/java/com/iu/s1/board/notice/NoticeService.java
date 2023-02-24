package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		
		
		return noticeDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO,MultipartFile [] files) throws Exception {
		String realPath = servletContext.getRealPath("/resources/notice/imgs");
		int a=noticeDAO.setBoardAdd(bbsDTO);
		FileManager fileManager = new FileManager();
		System.out.println(bbsDTO.getNum());
		for(MultipartFile f : files) {
			if(!f.isEmpty()) {
				String name=fileManager.fileSave(f, realPath);
				NoticeImgDTO noticeImgDTO= new NoticeImgDTO();
				noticeImgDTO.setFileName(name);
				noticeImgDTO.setNum(bbsDTO.getNum());
				noticeImgDTO.setOriName(f.getOriginalFilename());
				a=noticeDAO.setBoardImgAdd(noticeImgDTO);
				
			}
			
		}
		
		
		
		return a;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}
	
	
	
	
	
	
	
	
}
