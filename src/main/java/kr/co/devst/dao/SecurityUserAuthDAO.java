package kr.co.devst.dao;

public interface SecurityUserAuthDAO {
	
	void updateFailureCount(String memEmail);
	
	int checkFailureCount(String memEmail);
	
	void updateDisabled(String memEmail);
	
	void updateFailureCountReset(String memEmail);
	
	void updateNewAccessDate(String memEmail);
}
