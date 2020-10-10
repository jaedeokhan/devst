package kr.co.devst.dao;

import kr.co.devst.model.UserVO;

public interface SecurityUserAuthDAO {
	
	UserVO selectUserById(String memEmail);
	
	void updateNewAccessDate(String memEmail);

}
