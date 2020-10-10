package kr.co.devst.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import kr.co.devst.service.SecurityUserService;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Log log = LogFactory.getLog(LoginSuccessHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	
	private String memEmailName;
	private String defaultUrlName;
	
	@Autowired
	private SecurityUserService securityUserService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String memEmail = request.getParameter(memEmailName);
		
		/* securityUserService.resetFailureCnt(memEmail); */
		securityUserService.modifyAccessDate(memEmail);
		
		//에러 세션 지우기
		clearAuthenticationAttributes(request);
		
		//Redirect URL 작업
		resultRedirectStrategy(request, response, authentication);
		
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null) return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		if(savedRequest!=null) {
			log.debug("권한이 필요한 페이지에 접근했을 경우");
			useSessionUrl(request, response);
		} else {
			log.debug("직접 로그인 url로 이동했을 경우");
			useDefaultUrl(request, response);
		}
		
	}
	
	protected void useSessionUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		String targetUrl = savedRequest.getRedirectUrl();
		redirectStratgy.sendRedirect(request, response, targetUrl);
	}
	
	protected void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		redirectStratgy.sendRedirect(request, response, defaultUrlName);
	}

	public String getMemEmailName() {
		return memEmailName;
	}

	public void setMemEmailName(String memEmailName) {
		this.memEmailName = memEmailName;
	}

	public String getDefaultUrlName() {
		return defaultUrlName;
	}

	public void setDefaultUrlName(String defaultUrlName) {
		this.defaultUrlName = defaultUrlName;
	}

	

}
