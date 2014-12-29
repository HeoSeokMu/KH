package sugang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.sugangDAO;
import dto.memberDTO;
import dto.stuDTO;
import dto.sugangDTO;

@Controller
public class SugangChk {
	
	@RequestMapping(value="/sugangchk.kh")
	public ModelAndView chk_form(HttpSession session) throws Exception{
		
		memberDTO member = new memberDTO();
		MemberDAO memberdao = MemberDAO.getInstance();
		
		stuDTO stu = new stuDTO();
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		
		String number = (String) session.getAttribute("memId");
		//String number = "2014001001";  //���� �л� ����
		String semester = "1"; //�б�
		
		sugangDAO dao = sugangDAO.getInstance();
		
		list = dao.getSugangList(number, semester);
		for(sugangDTO dto : list){
			
			String y = dto.getL_type();
			if(y.equals("e")){
				dto.setL_type("�� ��");
			}else{
				dto.setL_type("�� ��");
			}
			dto.setS_date(dto.getS_date().substring(0,11));
			dto.setL_date(dto.getL_date().substring(0,11));
			
			String day = dto.getL_day();
			switch(day){
				case "��" : dto.setTime_day("100"); break;
				case "ȭ" : dto.setTime_day("200"); break;
				case "��" : dto.setTime_day("300"); break;
				case "��" : dto.setTime_day("400"); break;
				case "��" : dto.setTime_day("500"); break;
			}
		}
				
		stu = dao.getstu(semester, number);
		member = memberdao.member_info(number);
	
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", list);
		mv.addObject("member", member);
		mv.addObject("stu", stu);
		mv.setViewName("sugang_chk/sugang_chk.jsp");	
		
		return mv;
	}
}
