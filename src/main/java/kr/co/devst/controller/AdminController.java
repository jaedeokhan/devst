package kr.co.devst.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.devst.service.AdminService;

@Controller
@RequestMapping("/devst/admin/*")
public class AdminController {
	
	private static final Log log = LogFactory.getLog(AdminController.class);
	
	@Autowired private AdminService adminService;
	 
	
	// 
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView goAdminPage(ModelAndView mav) {
		
		int userCount = adminService.getUserCount();
		mav.addObject("userCount", userCount);
		mav.setViewName("/admin/admin");
		return mav;
	}
	
}
