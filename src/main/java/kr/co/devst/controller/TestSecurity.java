package kr.co.devst.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestSecurity {
	private static final Log log = LogFactory.getLog(TestSecurity.class);
	
	@RequestMapping(value="/user/loginPage", method=RequestMethod.GET)
	public String goLogin() {
		return "user/loginPage";
	}

    @RequestMapping(value="/access_denied_page")
    public String accessDeniedPage() throws Exception {
        return "/access_denied_page";
    }

	
}
