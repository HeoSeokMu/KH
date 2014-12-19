package sugang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SugangLiberal {
	
	@RequestMapping(value="/selectLiberal.kh")
	public ModelAndView form(HttpServletRequest req){
			
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sugang/liberal.jsp");
		return mv;
	}
}
