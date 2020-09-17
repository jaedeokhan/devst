package kr.co.devst.dao;

import kr.co.devst.model.UserVO;
public interface UserDao {

	// 이메일 중복체크
	public int emailChk(String memEmail) throws Exception;
	
	// 회원가입
	public int doJoin(UserVO userVO) throws Exception;
	
	
}
