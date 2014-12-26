package sugang.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.sugangDAO;
import dto.memberDTO;
import dto.stuDTO;
import dto.sugangDTO;

@Controller
public class SugangMain {
		
	@RequestMapping(value="/sugang.kh")
	public ModelAndView sugangForm(HttpServletRequest req) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		stuDTO stu = new stuDTO();
		memberDTO member = new memberDTO();
		
		String number = "2014001001";  //접속 학생 정보
		String semester = "1"; //학기
		
		sugangDAO dao = sugangDAO.getInstance();
		MemberDAO memberdao = MemberDAO.getInstance();
		stu = dao.getstu(semester, number);
		
		if(stu.getSubject_sum() > 0){
			list = dao.getSugangList(number, semester);
			for(sugangDTO dto : list){
				String day = dto.getL_day();
				switch(day){
					case "월" : dto.setL_day("100"); break;
					case "화" : dto.setL_day("200"); break;
					case "수" : dto.setL_day("300"); break;
					case "목" : dto.setL_day("400"); break;
					case "금" : dto.setL_day("500"); break;
				}
				
			}
			mv.addObject("list",list); 
		}
		
		member = memberdao.member_info(number);
		
		mv.addObject("member",member);
		mv.addObject("stu",stu);
		mv.setViewName("/sugang/sugangMain.jsp");
		return mv;
	}
	
	//(value="/sugangPro.kh", method=RequestMethod.POST)
	@RequestMapping(value="/sugangPro.kh")
	public ModelAndView sugangPro(HttpServletRequest req, @ModelAttribute stuDTO stu) throws Exception{
		
		String number = req.getParameter("stu_num");  //접속 학생 정보
		String semester = "1";
		
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		memberDTO member = new memberDTO();
		
		sugangDAO dao = sugangDAO.getInstance();
		MemberDAO memberdao = MemberDAO.getInstance();
		
		String value = "";
		
		for(int i=0; i<=9; i++){
			String code = req.getParameter("code"+i);
			String tableName = req.getParameter("table"+i);
			
			
			if(code != "" && tableName != ""){
				dao.setIn_stu_mi(code, tableName);
				dao.setIn_stu_pl(code, tableName);
				value += code+"="+tableName+",";	
			}
		}
		value = value.substring(0,value.lastIndexOf(","));
		stu.setAllcode(value);
		
		int result = dao.setStu(stu);
		member = memberdao.member_info(number);
		list = dao.getSugangList(number, semester);
		dao.setStu_hakjum(list, member);
		
		ModelAndView mv = new ModelAndView();
		
		if(result == 1){
			mv.setViewName("/sugang/sugangPro.jsp");
		}else{
			mv.setViewName("/sugang/sugangError.jsp");
		}
		return mv;	
	}
}
