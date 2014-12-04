package library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;

@Controller
public class bookDelete {
	
	
	@RequestMapping("/bookDelete.kh")
	public String bookDelete(HttpServletRequest req) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		String id = req.getParameter("book_id");
		libraryDTO book = book_dao.bookDelete(id);
		
		
		
		return "redirect:bookInsertForm.kh";
	}
	
	

}
