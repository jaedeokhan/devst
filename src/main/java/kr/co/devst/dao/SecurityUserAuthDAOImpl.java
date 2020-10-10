package kr.co.devst.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.devst.model.UserVO;

@Repository
public class SecurityUserAuthDAOImpl implements SecurityUserAuthDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.co.devst.dao.SecurityUserAuthDAO";
	

	public UserVO selectUserById(String memEmail) {
		return sqlSession.selectOne(NAME_SPACE + ".selectUserById", memEmail);
	}

	public void updateNewAccessDate(String memEmail) {
		sqlSession.update(NAME_SPACE + ".updateAccessDate", memEmail);
	}

}
