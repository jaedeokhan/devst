package kr.co.devst.dao;

import java.util.List;

import kr.co.devst.model.BoardVO;

public interface BoardDao {
	public int doWrite(BoardVO param);
	public List<BoardVO> getBoardListAll();
	public List<BoardVO> getBoardStudyList(int start, int num);
	public List<BoardVO> getBoardNomalList(int start, int num);
	public int getPageNum(String category);//카테고리를 파라미터로받아 페이징할 갯수 리턴
}
