package sugang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	
	@RequestMapping("/sugang.kh")
	public ModelAndView sugangForm(){
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sugang/sugangMain.jsp");
		return mv;
	}
}
