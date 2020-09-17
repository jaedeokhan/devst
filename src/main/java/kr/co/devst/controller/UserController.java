package kr.co.devst.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.devst.model.UserVO;
import kr.co.devst.service.MailService;
import kr.co.devst.service.UserService;

@Controller
@RequestMapping("/devst/user/*")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;
	
	// 이메일 인증페이지 이동
	@RequestMapping(value = "/emailCertifyPage", method = RequestMethod.GET)
	public String goEmailCertify(Model model) {
		log.debug("********** 이메일 인증 페이지 **********");
		
		return "/user/emailCertify";
	}
	
	// 이메일 인증번호 전송
	@RequestMapping(value = "/emailSend", method = RequestMethod.POST)
	@ResponseBody
	public int doEmailCertify(HttpServletRequest request, String memEmail) throws Exception {
		int result = 0;
		// 이메일 중복체크
		result = userService.emailChk(memEmail);
		if(result == 1) return result;
		
		mailService.emailSend(memEmail);
		 
	
		return result;
	}
	
//	// 이메일 중복체크
//		@RequestMapping(value = "/emailChk", method = RequestMethod.POST)
//		@ResponseBody
//		public int emailChk(UserVO userVO) throws Exception {
//			log.debug("********** 이에일 중복체크 @@실행@@ **********");
//			int result = userService.emailChk(userVO);
//			return result;
//		}
//		
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/joinPage", method = RequestMethod.GET)
	public String goJoin(Model model, @RequestParam (value = "error", required = false, defaultValue = "1")int error) {
		log.debug("********** 회원가입 페이지 **********");
		if(error != 1) {
			model.addAttribute("msg","알수없는 에러발생 잠시후 다시시도해주세요.");
		}
		return "/user/join";
	}
	
	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String doJoin(Model model, UserVO userVO, RedirectAttributes rttr) throws Exception {
		String resultAddr;
		log.debug("********** 회원가입  @@실행@@ **********");
		// 프로필 사진 여부 검사
//		if(userVO.getMem_profile_image().equals("") || userVO.getMem_profile_image() == null) {
//			userVO.setMem_profile_image("no_image");
//		}
		
		
		int result = userService.doJoin(userVO);
		System.out.println(result);
		if(result != 1) 
			resultAddr = "redirect:devst/user/joinPage?error=-1";
		else {
			rttr.addFlashAttribute("joinSuccesMsg","가입에 성공했습니다. 로그인해주세요.");
			resultAddr = "redirect:devst/user/loginPage";
		}
		return resultAddr;
	}

	
	// 로그인 페이지 이동
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String goLogin(Model model) {
		log.debug("********** 로그인 페이지 **********");
		return "/user/login";
	}
	

	
	

}
