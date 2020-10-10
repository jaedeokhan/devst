package kr.co.devst.service;

import kr.co.devst.model.UserVO;

public interface SecurityUserService {

	UserVO getUserById(String memEmail);
	
	void modifyAccessDate(String username);

}
