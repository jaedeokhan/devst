package kr.co.devst.service;

public interface SecurityUserService {

	void countFailure(String username);

	int checkFailureCount(String username);

	void disabledUsername(String username);

	void resetFailureCnt(String username);

	void modifyAccessDate(String username);

}
