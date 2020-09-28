package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.devst.dao.SecurityUserAuthDAOImpl;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {
	
	@Autowired
	private SecurityUserAuthDAOImpl securityUserAuthDAO;

	@Override
	public void countFailure(String memEmail) {
		securityUserAuthDAO.updateFailureCount(memEmail);
	}

	@Override
	public int checkFailureCount(String memEmail) {
		return securityUserAuthDAO.checkFailureCount(memEmail);
	}

	@Override
	public void disabledUsername(String memEmail) {
		securityUserAuthDAO.updateDisabled(memEmail);
	}

	@Override
	public void resetFailureCnt(String memEmail) {
		securityUserAuthDAO.updateFailureCountReset(memEmail);
	}

	@Override
	public void modifyAccessDate(String memEmail) {
		securityUserAuthDAO.updateNewAccessDate(memEmail);
	}

}
