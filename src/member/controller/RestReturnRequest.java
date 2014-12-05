package member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.memberDTO;

@Controller
public class RestReturnRequest {
	
	@RequestMapping(value="/returnSchool.kh")
	public ModelAndView returnSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("returnSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO dto = new memberDTO(); 
		dto = mDAO.member_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);						
		mv.setViewName("/member/returnSchool.jsp");
	
		return mv;
	}
	
	@RequestMapping(value="/restSchool.kh")
	public ModelAndView restSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("restSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO dto = new memberDTO(); 
		dto = mDAO.member_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);						
		mv.setViewName("/member/restSchool.jsp");
	
		return mv;
	}
}
