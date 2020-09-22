package kr.co.devst.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.devst.model.BoardVO;


@Repository
public class BoardDaoImple implements BoardDao{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.co.devst.dao.BoardDao";
	
	
	
	
	@Override
	public int doWrite(Map<String, String> map) {
		 
		return sqlSession.insert(NAME_SPACE+".doWrite",map);
	}




	@Override
	public List<BoardVO> getBoardListAll() {
		
		return sqlSession.selectList(NAME_SPACE+".getBoardListAll");
	}




	@Override
	public List<Map<String, String>> getBoardStudyList(int start, int num) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("num", num);
		
		return sqlSession.selectList(NAME_SPACE+".getBoardStudyList",map);
	}




	@Override
	public List<Map<String, String>> getBoardNomalList(int start, int num) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("num", num);
		return sqlSession.selectList(NAME_SPACE+".getBoardNomalList",map);
	}

	@Override
	public int getPageNum(String category) {
		return sqlSession.selectOne(NAME_SPACE+".getPageNum",category);
	}




	@Override
	public HashMap<String, String> getBoardOneInfo(BoardVO param) {
		return sqlSession.selectOne(NAME_SPACE+".getBoardOneInfo",param);
	}




	@Override
	public List<Map<String, String>> getMainBoardList10(String category) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		
		return sqlSession.selectList(NAME_SPACE+".getMainBoardList10",map);
	}
}
