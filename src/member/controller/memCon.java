package member.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.memberDTO;

@Controller
public class memCon{
	
	
	@RequestMapping(value="/joinForm.kh")
	public String form2(){
		return "/member/join_form.jsp";
	}
	
	
	@RequestMapping("/joinFormPro.kh")
	public ModelAndView formPro(@ModelAttribute memberDTO dto) throws Exception{
		
		/*session.setAttribute("memId", dto.getId());
		session.removeAttribute(arg0);
		session.invalidate();*/
		
		
		
		System.out.println(dto.getType());
		System.out.println(dto.getNum());
		System.out.println(dto.getPassword());
		System.out.println(dto.getName());
		System.out.println(dto.getSex());
		System.out.println(dto.getE_mail());
		System.out.println(dto.getS_phone());
		System.out.println(dto.getP_phone());
		
		System.out.println(dto.getBirth_yy());
		System.out.println(dto.getBirth_mm());
		System.out.println(dto.getBirth_dd());
		System.out.println(dto.getPro_img());
		System.out.println(dto.getAddress());
		System.out.println(dto.getPost());
		System.out.println(dto.getMajor());
		System.out.println(dto.getEnter_way());
		System.out.println(dto.getBefore_school());
		
		
		MemberDAO join_dao = MemberDAO.getInstance();
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		join_dao.insertMember(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		
		mv.setViewName("/member/test.jsp");
		return mv;
	}
}
