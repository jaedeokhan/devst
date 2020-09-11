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
	public int doWrite(BoardVO param) {
		 
		return sqlSession.insert(NAME_SPACE+".doWrite",param);
	}




	@Override
	public List<BoardVO> getBoardListAll() {
		
		return sqlSession.selectList(NAME_SPACE+".getBoardListAll");
	}




	@Override
	public List<BoardVO> getBoardStudyList(int start, int num) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("num", num);
		
		return sqlSession.selectList(NAME_SPACE+".getBoardStudyList",map);
	}




	@Override
	public List<BoardVO> getBoardNomalList(int start, int num) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("num", num);
		return sqlSession.selectList(NAME_SPACE+".getBoardNomalList",map);
	}




	@Override
	public int getPageNum(String category) {
		return sqlSession.selectOne(NAME_SPACE+".getPageNum",category);
	}

}
