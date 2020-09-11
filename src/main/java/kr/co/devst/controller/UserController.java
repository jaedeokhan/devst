package kr.co.devst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.devst.model.BoardVO;
import kr.co.devst.model.UserVO;
import kr.co.devst.service.BoardService;
import kr.co.devst.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/devst", method = RequestMethod.GET)
	public String goIdx(Model model) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		List<BoardVO> nomalList = new ArrayList<BoardVO>();
		List<BoardVO> studyList = new ArrayList<BoardVO>();
		list = boardService.getBoardListAll();
		nomalList = boardService.getBoardNomalList(0, 10);
		studyList = boardService.getBoardStudyList(0, 10);
		model.addAttribute("boardList",list);
		model.addAttribute("nomalList",nomalList);
		model.addAttribute("studyList",studyList);
		
		
		return "/index";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.GET)
	public String goJoin(Model model, @RequestParam (value = "error", required = false,defaultValue = "1")int error) {
		
		if(error != 1) {
			model.addAttribute("msg","알수없는 에러발생 잠시후 다시시도해주세요.");
		}
		return "/user/join";
	}
	
	@RequestMapping(value = "/devst/join", method = RequestMethod.POST)
	public String doJoin(Model model, UserVO param) {
		String resultAddr="/user/login";
	
		int result = userService.doJoin(param);
		if(result != 1) 
			resultAddr = "redirect:/devst/join?error=-1";
		else 
			model.addAttribute("joinSuccesMsg","가입에 성공했습니다 로그인해주세요.");
		return resultAddr;
	}
	
	@RequestMapping(value = "/devst/login", method = RequestMethod.GET)
	public String goLogin(Model model) {
		return "/user/login";
	}
	
	
	

}
