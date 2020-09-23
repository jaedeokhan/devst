package kr.co.devst.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.BoardDao;
import kr.co.devst.model.BoardVO;


@Service
public class BoardServiceImple implements BoardService{
	@Autowired
	private BoardDao boardDao;
		
	
	
	@Override
	public int doWrite(Map<String, String> map) {
		System.out.println("boardService");
		return boardDao.doWrite(map);
	}



	@Override
	public List<BoardVO> getBoardListAll() {
		return boardDao.getBoardListAll();
	}



	@Override
	public List<Map<String, String>> getBoardStudyList(int start, int num) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		list = boardDao.getBoardStudyList(start, num);
		for(int i=0;i<list.size();i++) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String date = transFormat.format(list.get(i).get("brd_update_date"));
			list.get(i).put("brd_update_date", date);

		}
				
		
		return list;
	}



	@Override
	public List<Map<String, String>> getBoardNomalList(int start, int num) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		list = boardDao.getBoardStudyList(start, num);
	
		for(int i=0;i<list.size();i++) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String date = transFormat.format(list.get(i).get("brd_update_date"));
			list.get(i).put("brd_update_date", date);

		}
				
		
		return list;
	}
	
	@Override
	public int getPageNum(String category) {
		
		return boardDao.getPageNum(category);
	}



	@Override
	public HashMap<String, String> getBoardOneInfo(BoardVO param) {
		return boardDao.getBoardOneInfo(param);
	}



	@Override
	public List<Map<String, String>> getMainBoardList10(String category) {
		return boardDao.getMainBoardList10(category);
	}

}
