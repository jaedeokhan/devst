package kr.co.devst.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devst/user/*")
public class SecurityUserController {
	
	private static final Log log = LogFactory.getLog(SecurityUserController.class);

	// 로그인 페이지 이동
	@RequestMapping(value = "/loginPage")
	public String goLogin(Model model) {
		log.debug("********** 로그인 페이지 **********");
		return "/user/loginPage.tilesAll";
	}
	
	// 로그인 권한 실패 403 => user 가 admin에 접근하면 띄워주는 화면
	@RequestMapping(value="/access_denied_page")
	public String goAccessDeined() {
		return "/access_denied_page.tilesAll";
	}
	
}
