package kr.co.devst.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.devst.model.UserVO;


@Repository
public class UserDaoImple implements UserDao{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.co.devst.dao.UserDao";
	
	

	
	
	
	@Override
	public int doJoin(UserVO param) {
		
		return  sqlSession.insert(NAME_SPACE+".doJoin",param);
	}

}
