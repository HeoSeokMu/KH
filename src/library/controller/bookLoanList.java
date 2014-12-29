package library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.libraryDTO;

@Controller
public class bookLoanList {
	@RequestMapping(value="/bookLoanList.kh")
	public ModelAndView bookLoanList(HttpServletRequest req, HttpSession session) throws Exception{
		String memId = (String) session.getAttribute("memId");
		List<libraryDTO> list = new ArrayList<libraryDTO>();
		bookDAO dbPro = bookDAO.getInstance();
		list = dbPro.getLoanList(memId);
		
		//해당 뷰에서 사용할 속성
		ModelAndView mv = new ModelAndView();
	    mv.addObject("list", list);
		
		mv.setViewName("/library/bookLoanList.jsp");
		return mv;
	}
}
