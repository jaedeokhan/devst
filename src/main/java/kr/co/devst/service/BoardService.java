package kr.co.devst.service;

import java.util.List;

import kr.co.devst.model.BoardVO;

public interface BoardService {
	public int doWrite(BoardVO param);
	public List<BoardVO> getBoardListAll();
	public List<BoardVO> getBoardStudyList(int start, int num);
	public List<BoardVO> getBoardNomalList(int start, int num); 
	public int getPageNum(String category);
}
