package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.SecurityUserAuthDAO;
import kr.co.devst.model.UserVO;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {
	
	@Autowired
	private SecurityUserAuthDAO securityUserAuthDAO;

	@Override
	public UserVO getUserById(String memEmail) {		
		return securityUserAuthDAO.selectUserById(memEmail);
	}
	
	@Override
	public void modifyAccessDate(String memEmail) {
		securityUserAuthDAO.updateNewAccessDate(memEmail);
	}

}
