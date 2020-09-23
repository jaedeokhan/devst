package kr.co.devst.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class TestController {
	
	private static final Log log = LogFactory.getLog(TestController.class);
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String goTest() {
		
		return "test";
	}
}
