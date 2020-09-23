package kr.co.devst.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.devst.model.BoardVO;

public interface BoardDao {
	/* public int doWrite(BoardVO param); */
	public int doWrite(Map<String, String> map);
	public List<BoardVO> getBoardListAll();
	public List<Map<String, String>> getBoardStudyList(int start, int num);
	public List<Map<String, String>> getBoardNomalList(int start, int num);
	public int getPageNum(String category);//카테고리를 파라미터로받아 페이징할 갯수 리턴
	public HashMap<String, String> getBoardOneInfo(BoardVO param);//pk와 category 두개를 받아 select
	public List<Map<String, String>> getMainBoardList10(String category); //index페이지에 navigation에 따라 표기할 10개의 리스트아이템
}
