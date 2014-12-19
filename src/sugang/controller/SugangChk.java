package sugang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.sugangDAO;
import dto.stuDTO;
import dto.sugangDTO;

@Controller
public class SugangChk {
	
	@RequestMapping(value="/sugangchk.kh")
	public ModelAndView chk_form(){
		
		stuDTO stu = new stuDTO();
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		
		String number = "2014001001";
		String grade = "1";
		
		sugangDAO dao = sugangDAO.getInstance();
		
		list = dao.getSugangList(number, grade);
		for(sugangDTO dto : list){
			
			String y = dto.getL_type();
			if(y.equals("e")){
				dto.setL_type("전 필");
			}else{
				dto.setL_type("전 선");
			}
			dto.setS_date(dto.getS_date().substring(0,11));
			dto.setL_date(dto.getL_date().substring(0,11));
		}
		
		stu = dao.getstu(grade, number);
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", list);
		mv.addObject("stu", stu);
		mv.setViewName("sugang_chk/sugang_chk.jsp");	
		
		return mv;
	}
}
