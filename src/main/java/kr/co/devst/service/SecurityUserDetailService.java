package kr.co.devst.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.devst.model.UserVO;

public class SecurityUserDetailService implements UserDetailsService{

	@Autowired
	private SecurityUserService securityUserService;
	private static final Log log = LogFactory.getLog(SecurityUserDetailService.class);
	@Override
	public UserDetails loadUserByUsername(String memEmail) throws UsernameNotFoundException {
		
		UserVO user = securityUserService.getUserById(memEmail);
		if(user == null) {
			
			throw new UsernameNotFoundException(memEmail);
		}
		return user;
	}
}