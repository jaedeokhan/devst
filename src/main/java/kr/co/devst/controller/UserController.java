package kr.co.devst.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.devst.model.BoardVO;
import kr.co.devst.model.UserVO;
import kr.co.devst.service.BoardService;
import kr.co.devst.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;
	
	
	
	@RequestMapping(value = "/joinPage", method = RequestMethod.GET)
	public String goJoin(Model model, @RequestParam (value = "error", required = false, defaultValue = "1")int error) {
		log.debug("********** 회원가입 페이지 **********");
		if(error != 1) {
			model.addAttribute("msg","알수없는 에러발생 잠시후 다시시도해주세요.");
		}
		return "/user/join";
	}
	
	@RequestMapping(value = "/doJoin", method = RequestMethod.POST)
	public String doJoin(Model model, UserVO userVO) throws Exception {
		String resultAddr;
		log.debug("********** 회원가입  @@실행@@ **********");
		// 프로필 사진 여부 검사
//		if(userVO.getMem_profile_image().equals("") || userVO.getMem_profile_image() == null) {
//			userVO.setMem_profile_image("no_image");
//		}
		int result = userService.doJoin(userVO);
		System.out.println(result);
		if(result != 1) 
			resultAddr = "redirect:/user/joinPage?error=-1";
		else 
			model.addAttribute("joinSuccesMsg","가입에 성공했습니다. 로그인해주세요.");
			resultAddr = "redirect:/user/loginPage";
		return resultAddr;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String goLogin(Model model) {
		return "/user/login";
	}
	

	// 이메일 중복체크
	@RequestMapping(value = "/emailChk", method = RequestMethod.POST)
	@ResponseBody
	public int emailChk(UserVO userVO) throws Exception {
		int result = userService.emailChk(userVO);
		return result;
	}
	
	

}
