package kr.co.devst.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.devst.model.BoardVO;
import kr.co.devst.service.BoardService;
import kr.co.devst.utils.Utils;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value = "/devst/board/regmod", method = RequestMethod.GET)
	public String goBoardRegMod(Model model) {
		return "/user/board/regMod";
	}
	
	@RequestMapping(value = "/devst/board/regmod", method = RequestMethod.POST)
	public void doBoardRegMod(Model model, HttpServletRequest request, BoardVO param,  HttpServletResponse response,MultipartHttpServletRequest multi, @RequestParam(value = "multiFile")MultipartFile multiFile) throws Exception{
	
		String dbFileNm =  Utils.uploadFile(multiFile, request,"12");//하드코딩된 부분, USER테이블과 조인시 동적으로할당하자
		param.setBoard_img(dbFileNm);
		 
		 
		int result = boardService.doWrite(param);
		if(result != 1) {//글쓰기 실패
			model.addAttribute("msg","글 쓰기에 실패했습니다.");
			request.setAttribute("msg", "글 쓰기에 실패했습니다.");
			RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/views/user/board/regMod.jsp");
			rd.forward(request, response);
			return;
		}
		response.sendRedirect("/devst/");
	}
	
	@RequestMapping(value = "/devst/board/category", method = RequestMethod.GET)
	public String goBoardShow(Model model, @RequestParam(value = "no", required = false, defaultValue = "0" )int no) {
		List <BoardVO> list = new ArrayList<BoardVO>(); //어떤 게시물을 담을 그릇
		String category = null;
		Integer pageNum = null;
		
		String currentTime = Utils.getCurrentDate("yyyyMMdd");
		
			switch(no) {
			case 0://잘못된 접근 메인으로
				return "redirect:/devst/";
				
			case 1://일반게시판
				list = boardService.getBoardNomalList(0, 10);
				pageNum = boardService.getPageNum("일반");
				
				category = "일반게시판";
				break;
			case 2://스터디게시판
				
				list = boardService.getBoardStudyList(0, 10);
				pageNum = boardService.getPageNum("스터디구인");
				category = "스터디게시판";
				break;
			case 3://???
				break;
			case 4://???
				break;
				
		}
		model.addAttribute("category",category);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("list",list);
		model.addAttribute("currentTime",currentTime);
		return "/user/board/board";
	}
	
	
	
	
}
