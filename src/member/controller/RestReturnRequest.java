package member.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.RestReturnBoard_DTO;
import dto.memberDTO;

@Controller
public class RestReturnRequest {
	
	@RequestMapping(value="/returnSchool.kh")
	public ModelAndView returnSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("returnSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO mDTO = new memberDTO(); 
		mDTO = mDAO.student_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);
		mv.setViewName("/member/returnSchool.jsp");
	
		return mv;
	}
	
	@RequestMapping(value="/restSchool.kh")
	public ModelAndView restSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("restSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO mDTO = new memberDTO(); 
		mDTO = mDAO.student_info(id);
		
		System.out.println(mDTO.getAddr());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);						
		mv.setViewName("/member/restSchool.jsp");
	
		return mv;
	}
	
	@RequestMapping(value="/restInsert.kh")
	public ModelAndView restInsert(HttpServletRequest req) throws Exception{
		
		System.out.println("restInsert =================== : ");
		RestReturnBoard_DTO rrb_DTO = new RestReturnBoard_DTO();  
		
		rrb_DTO.setMajor(req.getParameter("major"));
		rrb_DTO.setAddr(req.getParameter("addr"));
		rrb_DTO.setEmail(req.getParameter("email"));
		int grade = Integer.parseInt(req.getParameter("grade"));
		rrb_DTO.setGrade(grade);
		rrb_DTO.setId(req.getParameter("id"));
		rrb_DTO.setName(req.getParameter("name"));
		rrb_DTO.setPhone(req.getParameter("s_phone"));
		rrb_DTO.setTime(req.getParameter("time"));
		rrb_DTO.setWhy(req.getParameter("why"));
		rrb_DTO.setWhy_detail(req.getParameter("why_detail"));
		rrb_DTO.setResult(req.getParameter("result"));
		rrb_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		mDAO.insertRestReturnBoard(rrb_DTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", rrb_DTO);						
		mv.setViewName("redirect:/notice_board.kh");
	
		return mv;
	}
}
