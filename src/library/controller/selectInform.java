package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.memberDTO;

@Controller
public class selectInform {
	@RequestMapping(value="/selectInform.kh", method=RequestMethod.GET)
	public ModelAndView select(HttpServletRequest req) throws Exception{
		String s_num = req.getParameter("num");
		String book_id = req.getParameter("book_id");
		String book_title = req.getParameter("book_title");
		memberDTO dto = new memberDTO();
		
		bookDAO dbPro = bookDAO.getInstance();
		dto = dbPro.getSelectInform(s_num);
		
		int i = dto.getS_phone().indexOf("]") + 1;	//통신사 잘라내기
		String phone = dto.getS_phone().substring(i);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/library/inputNumForm.jsp");
		mv.addObject("s_num", s_num);
		mv.addObject("book_id", book_id);
		mv.addObject("book_title", book_title);
		mv.addObject("s_name", dto.getName());
		mv.addObject("s_phone", phone);
		return mv;
	}

}
