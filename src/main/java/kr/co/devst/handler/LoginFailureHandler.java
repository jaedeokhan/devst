package kr.co.devst.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import kr.co.devst.service.SecurityUserService;
import kr.co.devst.utils.MessageUtils;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	private SecurityUserService securityUserService;
	 
	private String memEmailName;
	private String memPasswordName;
	private String errorMessageName;
	private String defaultFailureUrlName;
	private String loginFailCountName;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		String memEmail = request.getParameter(memEmailName);
		String memPassword = request.getParameter(memPasswordName);
		String errorMsg = null;
		int loginFailcount = 0;
		
		if(exception instanceof BadCredentialsException) {
			loginFailcount = loginFailureCount(memEmail); 
			errorMsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof DisabledException) {
			errorMsg = MessageUtils.getMessage("error.Disaled");
		} else if(exception instanceof CredentialsExpiredException) {
			errorMsg = MessageUtils.getMessage("error.CredentialsExpired");
		} else if(exception instanceof SessionAuthenticationException) {
			errorMsg = MessageUtils.getMessage("error.SessionAuthentication");
		}
		
		request.setAttribute(memEmailName, memEmail);
		request.setAttribute(memPasswordName, memPassword);
		request.setAttribute(errorMessageName, errorMsg);
		request.setAttribute(loginFailCountName, loginFailcount);
		request.getRequestDispatcher(defaultFailureUrlName).forward(request, response);
	}
	
	
	protected Integer loginFailureCount(String memEmail) {
	  securityUserService.countFailure(memEmail); 
	  int cnt = securityUserService.checkFailureCount(memEmail); 
	  if(cnt==5) {
		  securityUserService.disabledUsername(memEmail); 
	  } 
	  return cnt; 
	  }

	public String getMemEmailName() {
		return memEmailName;
	}


	public void setMemEmailName(String memEmailName) {
		this.memEmailName = memEmailName;
	}


	public String getMemPasswordName() {
		return memPasswordName;
	}


	public void setMemPasswordName(String memPasswordName) {
		this.memPasswordName = memPasswordName;
	}


	public String getErrorMessageName() {
		return errorMessageName;
	}


	public void setErrorMessageName(String errorMessageName) {
		this.errorMessageName = errorMessageName;
	}


	public String getDefaultFailureUrlName() {
		return defaultFailureUrlName;
	}


	public void setDefaultFailureUrlName(String defaultFailureUrlName) {
		this.defaultFailureUrlName = defaultFailureUrlName;
	}


	public String getLoginFailCountName() {
		return loginFailCountName;
	}


	public void setLoginFailCountName(String loginFailCountName) {
		this.loginFailCountName = loginFailCountName;
	}
	
	

}
