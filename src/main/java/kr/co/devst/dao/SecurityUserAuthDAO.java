package kr.co.devst.dao;

import kr.co.devst.model.UserVO;

public interface SecurityUserAuthDAO {
	
	UserVO getUserById(String memEmail);
	
	void updateFailureCount(String memEmail);
	
	int checkFailureCount(String memEmail);
	
	void updateDisabled(String memEmail);
	
	void updateFailureCountReset(String memEmail);
	
	void updateNewAccessDate(String memEmail);

}
