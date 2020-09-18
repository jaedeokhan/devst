package kr.co.devst.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.devst.model.BoardVO;
import kr.co.devst.model.BoardVO_backup;

public interface BoardService {
	public int doWrite(Map<String, String> map);
	public List<BoardVO> getBoardListAll();
	public List<Map<String, String>> getBoardStudyList(int start, int num);
	public List<Map<String, String>> getBoardNomalList(int start, int num); 
	public int getPageNum(String category);
	
	public HashMap<String, String> getBoardOneInfo(BoardVO param);
}
