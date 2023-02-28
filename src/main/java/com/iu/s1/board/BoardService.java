package com.iu.s1.board;

public interface BoardService extends BbsService{
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
	
	
}
