package library.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;

@Controller
public class bookInsert{
	
	
	@RequestMapping(value="/bookInsertForm.kh")
	public String form(){
		return "/library/bookInsertForm.jsp";
	}
	
	
	@RequestMapping("/bookInsertFormPro.kh")
	public ModelAndView formPro(@ModelAttribute libraryDTO dto) throws Exception{
		
		/*session.setAttribute("memId", dto.getId());
		session.removeAttribute(arg0);
		session.invalidate();*/
		
		
		
	
		bookInsertDAO library_dao = bookInsertDAO.getInstance();
		dto.setInsert_year(new Timestamp(System.currentTimeMillis()));
		library_dao.bookInsert(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		
		mv.setViewName("/library/bookInsertInfo.jsp");
		return mv;
	}
}
