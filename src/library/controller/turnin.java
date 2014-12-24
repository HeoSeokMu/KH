package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;

@Controller
public class turnin {

	@RequestMapping(value="/turnin.kh", method=RequestMethod.GET)
	public ModelAndView turnin(HttpServletRequest req) throws Exception{
		int book_id = Integer.parseInt(req.getParameter("book_id"));
		
		bookDAO dbPro = bookDAO.getInstance();
		dbPro.turnin(book_id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("book_id", book_id);
		mv.setViewName("/email.kh");
		return mv;
	}
}