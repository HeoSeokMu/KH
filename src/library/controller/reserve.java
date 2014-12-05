package library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.reserveDAO;
import dto.reserveDTO;

@Controller
public class reserve{
	
	@RequestMapping(value="/reserveForm.kh", method=RequestMethod.POST)
	public ModelAndView reserve(HttpServletRequest req) throws Exception{
		String b_num = req.getParameter("b_num");
		String b_name = req.getParameter("b_name");
		String email = req.getParameter("email");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("b_num", b_num);		//책번호와 제목을 파라미터로 보네줌
		mv.addObject("b_name", b_name);
		mv.addObject("email", email);
		mv.setViewName("/library/reserveForm.jsp");
		return mv;
	}
	
	@RequestMapping(value="/reservePro.kh", method=RequestMethod.POST)
	public ModelAndView reservePro(HttpServletRequest req, HttpSession session, @ModelAttribute reserveDTO dto) throws Exception{
		String s_num = (String) session.getAttribute("memId"); 
		String b_num = req.getParameter("b_num");
		String b_name = req.getParameter("b_name");
		String email = req.getParameter("email");
		dto.setEmail(email);
		dto.setS_num(s_num);
		
		reserveDAO dbPro = reserveDAO.getInstance();
		dbPro.insertReserve(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("b_num", b_num);		//책번호와 제목을 파라미터로 보네줌
		mv.addObject("b_name", b_name);
		mv.addObject("dto", dto);
		mv.setViewName("/library/reservePro.jsp");
		return mv;
	}
}