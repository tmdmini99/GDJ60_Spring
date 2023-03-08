package com.iu.s1.board;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService extends BbsService{
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
	
	public int setBoardUpdate(BbsDTO bbsDTO,HttpSession session, MultipartFile[] multipartFiles, Long []fileNums)throws Exception;
	
	
}
