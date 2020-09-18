package kr.co.devst.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static String namespace = "kr.co.devst.dao.AdminDAO";
	
	@Override
	public int selectUserCount() {
		
		return sqlSession.selectOne(namespace + ".selectUserCount");
	}
	
	

}
