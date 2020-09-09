package kr.co.devst.service;

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
		return boardDao.getBoardStudyList(start, num);
	}



	@Override
	public List<BoardVO> getBoardNomalList(int start, int num) {
		return boardDao.getBoardNomalList(start, num);
	}

}
