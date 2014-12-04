package library.controller;


import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;

@Controller
public class bookModify {
	
		
		@RequestMapping("/bookModifyForm.kh")
		public ModelAndView bookView(HttpServletRequest req) throws Exception{
			
			bookInsertDAO book_dao = bookInsertDAO.getInstance();
			String id = req.getParameter("book_id");
			libraryDTO book = book_dao.getBookView(id);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("book", book);
			
			mv.setViewName("/library/bookModifyForm.jsp");
			
			return mv;
	}
	
	@RequestMapping("/bookModifyFormPro.kh")
	public ModelAndView bookModifyFormPro(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		
		book_dao.bookModify(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("book_id", req.getParameter("book_id"));
		mv.addObject("book_title", req.getParameter("book_title"));
		mv.addObject("book_location", req.getParameter("book_location"));
		mv.addObject("book_writer", req.getParameter("book_writer"));
		mv.addObject("book_publisher", req.getParameter("book_publisher"));
		mv.addObject("book_supplment", req.getParameter("book_supplement"));
		
		
		mv.setViewName("/library/bookModifyFormPro.jsp");
		
		return mv;
	}
}
