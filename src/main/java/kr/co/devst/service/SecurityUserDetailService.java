package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.devst.dao.SecurityUserAuthDAOImpl;
import kr.co.devst.model.UserVO;

public class SecurityUserDetailService implements UserDetailsService{

	@Autowired
	private SecurityUserAuthDAOImpl securityUserAuthDAO;
	
	@Override
	public UserDetails loadUserByUsername(String memEmail) throws UsernameNotFoundException {
		UserVO user = securityUserAuthDAO.getUserById(memEmail);
		if(user == null) {
			throw new UsernameNotFoundException(memEmail);
		}
		return user;
	}
}
