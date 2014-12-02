package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.rentDAO;
import dao.reserveDAO;

@Controller
public class reserve{
	
	@RequestMapping(value="/reserveForm.kh", method=RequestMethod.POST)
	public ModelAndView form(HttpServletRequest req) throws Exception{
		String reserveDate = null;
		String rentDate = null;
		String b_num = req.getParameter("b_num");
		String b_name = req.getParameter("b_name");
		
		reserveDAO reservePro = reserveDAO.getInstance();
		rentDAO rentPro = rentDAO.getInstance();
		reserveDate = reservePro.getDate(b_num);		//예약테이블에서 해당 책을 빌린 날짜 가져옴
		rentDate = rentPro.getDate(b_num);				//대여테이블에서 대여 마지막 날짜 가져옴
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("b_num", b_num);		//책번호와 제목을 파라미터로 보네줌
		mv.addObject("b_name", b_name);
		mv.setViewName("/library/reserveForm.jsp");
		return mv;
	}
}