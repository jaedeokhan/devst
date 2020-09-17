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
	
	
	// 회원가입
	@Override
	public int doJoin(UserVO userVO) {
		return  sqlSession.insert(NAME_SPACE+".doJoin", userVO);
	}

	// 이메일 중복체크
	@Override
	public int emailChk(String memEmail) throws Exception {
		int result = sqlSession.selectOne(NAME_SPACE+ ".emailChk", memEmail);
		return result;
	}

}
