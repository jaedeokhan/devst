package kr.co.devst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.BoardDao;
import kr.co.devst.model.BoardVO;


@Service
public class BoardServiceImple implements BoardService{
	@Autowired
	private BoardDao boardDao;
		
	
	
	@Override
	public int doWrite(BoardVO param) {
		System.out.println("boardService");
		return boardDao.doWrite(param);
	}



	@Override
	public List<BoardVO> getBoardListAll() {
		return boardDao.getBoardListAll();
	}



	@Override
	public List<BoardVO> getBoardStudyList(int start, int num) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardDao.getBoardStudyList(start, num);
		for(int i=0;i<list.size();i++) {
			String date	 = list.get(i).getM_dt();
			list.get(i).setM_dt(date.split(" ")[0].replace("-", ""));
		}
		
		return list;
	}



	@Override
	public List<BoardVO> getBoardNomalList(int start, int num) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardDao.getBoardNomalList(start, num);
		for(int i=0;i<list.size();i++) {
			String date	 = list.get(i).getM_dt();
			list.get(i).setM_dt(date.split(" ")[0].replace("-", ""));
		}
		
		return list;
	}



	@Override
	public int getPageNum(String category) {
		
		return boardDao.getPageNum(category);
	}

}
