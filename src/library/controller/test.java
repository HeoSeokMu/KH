package library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test{
	
	@RequestMapping("/test.kh")
	public String test(){
		return "/library/test.jsp";
	}
}