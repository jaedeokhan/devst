package kr.co.devst.service;

import javax.servlet.http.HttpSession;

public interface MailService {
	
	// 이메일 인증코드 전송
	public void emailSend(HttpSession session, String memEmail) throws Exception;

	public boolean emailCertify(HttpSession session, String memEmail, int inputNum);
	
	
}
