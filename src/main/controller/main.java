package main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class main{
	@RequestMapping("/KHInfo.kh")
	public String KH_info(){
		return "/main/Login_form.jsp";
	}
}