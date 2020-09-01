package kr.co.devst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.devst.model.UserVO;
import kr.co.devst.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/devst", method = RequestMethod.GET)
	public String goIdx() {
		log.debug("===>> index page ===>>");
		return "/index";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.GET)
	public String goJoin(Model model) {
		log.debug("===>> 회원가입 페이지 ===>>");
		return "/user/join";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.POST)
	public String doJoin(Model model, UserVO param) {
		log.debug("===>> 회원가입 수행 ===>>");
		System.out.println(param.getId());
		System.out.println(param.getPw());
		System.out.println(param.getName());
		System.out.println(param.getNick());
		userService.doJoin(param);
		
		return "/user/login";
	}
	

}
