package library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;

@Controller
public class bookInsert{
	
	@RequestMapping(value="/bookInsertFormPro.kh", method=RequestMethod.POST)
	public ModelAndView formPro(MultipartHttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		bookInsertDAO abc = bookInsertDAO.getInstance();
		
		String str = "abc";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("string", str);
		mv.setViewName("/library/inputNumForm.jsp");
		return mv;
	}
}
