package kr.co.devst.service;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.devst.model.MailHandler;


@Service
public class MailServiceImple implements MailService{

	@Autowired
	private final JavaMailSender mailSender = null;

	
	// 이메일 인증번호 전송
	@Override
	public void emailSend(HttpSession session, String memEmail) throws Exception {
		Random random = new Random();
        int certificationNum = random.nextInt(4589362) + 49311; //이메일로 받는 인증코드 난수
        
        String setfrom = "wcsjing@gmail.com";
        String tomail = memEmail; // 받는 사람 이메일
        String title = "devst 회원가입 인증번호입니다."; // 제목
        String content = 
        		
        System.getProperty("line.separator")+ // os상관없이 줄 띄움
                
        "안녕하세요 회원님 devst를 이용해주셔서 감사합니다."
        
        +System.getProperty("line.separator")+

        " 인증번호는 " +certificationNum+ " 입니다. "    
        
        +System.getProperty("line.separator")+
        
        "받으신 인증번호를 입력해주세요."; // 내용
        System.out.println(setfrom + tomail + title + content);
        try {
        	MailHandler mailHandler = new MailHandler(mailSender);
         
            mailHandler.setFrom(setfrom); // 보내는사람 생략X
            mailHandler.setTo(tomail); // 받는사람 이메일
            mailHandler.setSubject(title); // 메일제목은 생략 가능
            mailHandler.setText(content); // 메일 내용     
            mailHandler.send();
            
            session.setAttribute(memEmail, certificationNum);
        } catch (Exception e) {
            System.out.println("인증번호 전송에러" + e);
        }
	}


	@Override
	public boolean emailCertify(HttpSession session, String memEmail, int inputNum) {
		try {
			int cerNum = 0;
			
			if(session.getAttribute(memEmail) != null) {
				cerNum = (int) session.getAttribute(memEmail);
			} else if(session.getAttribute(memEmail) == null) {
				return false;
			}
		
			
			if(cerNum == inputNum) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
