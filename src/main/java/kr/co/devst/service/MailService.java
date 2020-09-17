package kr.co.devst.service;

public interface MailService {
	
	// 이메일 인증코드 전송
	public void emailSend(String memEmail) throws Exception;
	
	
}
