package kr.co.devst.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.devst.model.UserVO;

@Repository
public class SecurityUserAuthDAOImpl {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.co.devst.dao.SecurityUserAuthDAO";
	

	public UserVO getUserById(String memEmail) {
		return sqlSession.selectOne(NAME_SPACE + ".selectUserById", memEmail);
	}

	public void updateFailureCount(String memEmail) {
		sqlSession.update(NAME_SPACE + ".updateFailureCount", memEmail);
	}
	
	public int checkFailureCount(String memEmail) {
		return sqlSession.selectOne(NAME_SPACE + ".checkFailureCount", memEmail);
	}
	
	public void updateDisabled(String memEmail) {
		sqlSession.update(NAME_SPACE + ".updateUnenabled", memEmail);
	}

	public void updateFailureCountReset(String memEmail) {
		sqlSession.update(NAME_SPACE + ".updateFailureCountReset", memEmail);
	}

	public void updateNewAccessDate(String memEmail) {
		sqlSession.update(NAME_SPACE + ".updateAccessDate", memEmail);
	}

}
