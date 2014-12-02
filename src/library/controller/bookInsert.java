package library.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;



@Controller
public class bookInsert{
	
	
	
	
	@RequestMapping(value="bookInsertForm.kh")
	public String form(){
		return "/library/bookInsertForm.jsp";
	}
	
	/*@RequestMapping(value="/bookInsertForm.kh", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView form(HttpServletRequest req) throws Exception{
		String id = req.getParameter("book_id"); 
		int book_id = Integer.parseInt(id);
		String book_title = req.getParameter("book_title");
		String book_location = req.getParameter("book_location");
		String book_writer = req.getParameter("book_writer");
		String book_pulisher = req.getParameter("book_pulisher");
		String b_year = req.getParameter("book_year");
		int book_year = Integer.parseInt("b_year");
		String book_supplment = req.getParameter("book_supplment");
		String file_orgname = req.getParameter("file_orgname");

		
		System.out.println(book_id);

		ModelAndView mv = new ModelAndView();

		mv.addObject("book_id", book_id);		
		mv.addObject("book_title", book_title);
		mv.setViewName("/library/bookInsertForm.jsp");
		return mv;
	}
*/
	@RequestMapping(value="/bookInsertFormPro.kh")
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		
	
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		book_dao.bookInsert(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("book_id", req.getParameter("book_id"));
		mv.addObject("book_title", req.getParameter("book_title"));
		mv.addObject("book_location", req.getParameter("book_location"));
		mv.addObject("book_writer", req.getParameter("book_writer"));
		mv.addObject("book_publisher", req.getParameter("book_publisher"));
		mv.addObject("book_supplment", req.getParameter("book_supplement"));
		
		mv.setViewName("/library/bookInsertFormPro.jsp");
		
		return mv;
	}
}
