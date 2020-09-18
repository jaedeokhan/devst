package kr.co.devst.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.devst.model.BoardVO;
import kr.co.devst.service.BoardService;
import kr.co.devst.utils.Utils;

@Controller
public class BoardController {
	
	private static final Log log = LogFactory.getLog(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/devst", method = RequestMethod.GET)
	public String goIdx(Model model) {
		log.debug("********* 인덱스 페이지 *********");
		List<BoardVO> list = new ArrayList<BoardVO>();
		List<Map<String, String>> nomalList = new ArrayList<Map<String, String>>();
		List<Map<String, String>> studyList = new ArrayList<Map<String, String>>();
//		List<BoardVO> nomalList = new ArrayList<BoardVO>();
//		List<BoardVO> studyList = new ArrayList<BoardVO>();
		list = boardService.getBoardListAll();		
		nomalList = boardService.getBoardNomalList(0, 10);
		studyList = boardService.getBoardStudyList(0, 10);
		model.addAttribute("boardList",list);
		model.addAttribute("nomalList",nomalList);
		model.addAttribute("studyList",studyList);
		
		
		return "/index";
	}
	
	
	@RequestMapping(value = "/devst/board/regmod", method = RequestMethod.GET)
	public String goBoardRegMod(Model model) {
		log.debug("********* 게시판 작성 페이지  *********");
		return "/user/board/regMod";
	}
	
	@RequestMapping(value = "/devst/board/regmod", method = RequestMethod.POST)
	public void doBoardRegMod(Model model, HttpServletRequest request,@Valid BoardVO param, BindingResult bindReulst ,HttpServletResponse response,MultipartHttpServletRequest multi, @RequestParam(value = "multiFile")MultipartFile multiFile) throws Exception{
		log.debug("********* 게시판 작성 @@실행@@  *********");
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/views/user/board/regMod.jsp");
		if(bindReulst.hasErrors()) {//클라이언트 전송에러
			request.setAttribute("msg", "글 쓰기에 실패했습니다.");
			rd.forward(request, response);
			return;
		}
		
		
		String dbFileNm =  Utils.uploadFile(multiFile, request,"12");//하드코딩된 부분, USER테이블과 조인시 동적으로할당하자
		param.setBrdImage(dbFileNm);
		
		
		Map<String,String> map = new HashMap<String, String>();
		map = Utils.ObjToMap(param);
		map.put("memId", "11");
			
		
		int result = boardService.doWrite(map);
		if(result != 1) {//글쓰기 실패 db에러
			model.addAttribute("msg","글 쓰기에 실패했습니다.");
			request.setAttribute("msg", "글 쓰기에 실패했습니다.");
			rd.forward(request, response);
			return;
		}
		response.sendRedirect("/devst/");
	}
	
	@RequestMapping(value = "/devst/board/category", method = RequestMethod.GET)
	public String goBoardShow(Model model,@RequestParam(value = "pageNum",required = false, defaultValue = "1")int pageNum,
											@RequestParam(value = "no", required = false, defaultValue = "0")int no, RedirectAttributes rtta) {
		log.debug("********* 게시판 각각 세부사항 페이지  *********");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(); //어떤 게시물을 담을 그릇
		String category = null;
		Integer pageMaxNum = null;
		String currentTime = Utils.getCurrentDate("yyyyMMdd");
		System.out.println("pageNum : "+pageNum);
		
		
			switch(no) {
			case 0://잘못된 접근 메인으로
				return "redirect:/devst/";
				
			case 1://일반게시판
				list = boardService.getBoardNomalList((pageNum-1)*10, 10);
				pageMaxNum = boardService.getPageNum("일반");
				
				category = "일반게시판";
				break;
			case 2://스터디게시판
				
				list = boardService.getBoardStudyList((pageNum-1)*10, 10);
				pageMaxNum = boardService.getPageNum("스터디구인");
				category = "스터디게시판";
				break;
			case 3://???
				break;
			case 4://???
				break;
			default:
				return "redirect:/devst/";
		}
			
			//없는페이지 접근시 예외처리 지금은 다른작업때문에 주석중
//			if(pageNum>pageMaxNum.intValue()) {
//				System.out.println("pageNum : "+pageNum);
//				System.out.println("pageMaxNum : "+pageMaxNum);
//				rtta.addFlashAttribute("error","잘못된 접근입니다.");
//				return "redirect:/devst/board/category?no="+no;
//			}
			
		model.addAttribute("pageNum",pageNum);//현재 페이지쪽수(시작이 0)	
		model.addAttribute("no",no);//URL에 들어가는 카테고리 
		model.addAttribute("category",category);//게시판에 들어갈 카테고리명
		model.addAttribute("pageMaxNum",20);//최대 페이지 수
		model.addAttribute("list",list);
		model.addAttribute("currentTime",currentTime);
		return "/user/board/board";
	}
	
	
		
	//작업중 삭제 ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ 안돼!!
	/*
	 * @RequestMapping(value = "/devst/board/detail/category", method =
	 * RequestMethod.GET) public String goBoardDetail(Model model,
	 * 
	 * @RequestParam(value = "id", required = false, defaultValue = "0")int id,
	 * 
	 * @RequestParam(value = "no", required = false, defaultValue = "0")int no ){
	 * if(id == 0 || no == 0) {//올바르진 않은 접근 return "/user/board/board"; } BoardVO
	 * param = new BoardVO(); param.setBrdId(id);
	 * param.setBrdCategory(Utils.MappingCategory(no)); System.out.println("여ㅣㄱ");
	 * BoardVO getOne = boardService.getBoardOneInfo(param);
	 * System.out.println("ㅇㅇ"); if(getOne == null) { return
	 * "/devst/board/category?no="+no; } model.addAttribute("oneInfo",getOne);
	 * 
	 * 
	 * 
	 * return "/user/board/boardDetail"; }
	 */
	
	
	
}
