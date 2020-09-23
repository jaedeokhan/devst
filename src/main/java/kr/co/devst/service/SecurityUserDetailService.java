package kr.co.devst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.devst.dao.SecurityUserAuthDAO;
import kr.co.devst.model.SecurityUserDetail;

public class SecurityUserDetailService implements UserDetailsService{

	@Autowired
	private SecurityUserAuthDAO securityUserAuthDAO;
	
	@Override
	public UserDetails loadUserByUsername(String memEmail) throws UsernameNotFoundException {
		SecurityUserDetail user = securityUserAuthDAO.getUserById(memEmail);
		if(user == null) {
			throw new UsernameNotFoundException(memEmail);
		}
		return user;
	}
}
