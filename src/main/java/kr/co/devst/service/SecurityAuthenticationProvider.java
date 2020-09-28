package kr.co.devst.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.co.devst.controller.UserController;
import kr.co.devst.model.UserVO;

public class SecurityAuthenticationProvider implements AuthenticationProvider{
	
	private static final Log log = LogFactory.getLog(SecurityAuthenticationProvider.class);

	@Autowired
	private SecurityUserDetailService securityUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String memEmail = (String) authentication.getPrincipal();
        String memPassword = (String) authentication.getCredentials();
        
        log.debug("AuthenticationProvider :: 실행");

        UserVO user = (UserVO) securityUserDetailService.loadUserByUsername(memEmail);
        
        if(!user.isEnabled()) {
        	log.debug("AuthenticationProvider :: isEnabled 걸림 == 계정 비활성화");
            throw new BadCredentialsException(memEmail);
        }
        
        if(!passwordEncoder.matches(memPassword, user.getMemPassword())) {
        	log.debug("AuthenticationProvider :: 비밀번호 불일치");
        	throw new BadCredentialsException(memEmail);
        }
        
        log.debug("AuthenticationProvider + memEmail + :: 성공");
        
		return new UsernamePasswordAuthenticationToken(memEmail, memPassword, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
