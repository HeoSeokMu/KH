package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.Action;

@Controller
public class LoginForm{
	
	@RequestMapping("/LoginForm.kh")
	public String LoginForm(){
		return "/member/login_form.jsp";
	}
}