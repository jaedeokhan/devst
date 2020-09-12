package kr.co.devst.controller;

import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
	public String goBoard(Model model) {
		return "/user/board/regMod";
	}
	
	@RequestMapping(value = "/devst/board/regmod", method = RequestMethod.POST)
	public void doBoard(Model model, HttpServletRequest request, BoardVO param,  HttpServletResponse response,MultipartHttpServletRequest multi, @RequestParam(value = "multiFile")MultipartFile multiFile) throws Exception{
		/*
		 * String fileName = multiFile.getOriginalFilename();//db저장될 파일명
		 * System.out.println("mulitFile : "+fileName); String path =
		 * request.getSession().getServletContext().getRealPath("uploadImg/");
		 * path+="1"; System.out.println("path : "+path); File file = new File(path);
		 * if(!file.exists()) {//없으면 생성 System.out.println("경로 : "+path); file.mkdir();
		 * }
		 * 
		 * byte[] bytes; file = new File(path,multiFile.getOriginalFilename());
		 * System.out.println("fileName : "+multiFile.getOriginalFilename());
		 * 
		 * 
		 * 
		 * try { bytes = multiFile.getBytes(); FileCopyUtils.copy(bytes, file);
		 * param.setBoard_img(fileName); }catch (Exception e) { e.printStackTrace(); }
		 */
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
	
	
	
	
}
