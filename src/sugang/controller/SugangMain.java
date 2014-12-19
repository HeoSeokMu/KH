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

import dao.sugangDAO;
import dto.stuDTO;
import dto.sugangDTO;

@Controller
public class SugangMain {
		
	@RequestMapping(value="/sugang.kh")
	public ModelAndView sugangForm(HttpServletRequest req) throws SQLException{
		ModelAndView mv = new ModelAndView();
		
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		stuDTO stu = new stuDTO();
		String number = "2014001005";  //접속 학생 정보
		String grade = "1";
		
		sugangDAO dao = sugangDAO.getInstance();
		stu = dao.getstu(grade, number);
		if(stu.getSubject_sum() > 0){
			list = dao.getSugangList(number, grade);
			mv.addObject("list",list);
		}

		mv.addObject("stu",stu);
		mv.setViewName("/sugang/sugangMain.jsp");
		return mv;
	}
	
	//(value="/sugangPro.kh", method=RequestMethod.POST)
	@RequestMapping(value="/sugangPro.kh")
	public ModelAndView sugangPro(HttpServletRequest req, @ModelAttribute stuDTO stu) throws SQLException{
		
		sugangDAO dao = sugangDAO.getInstance();
		String value = "";
		
		for(int i=0; i<=9; i++){
			String code = req.getParameter("code"+i);
			String tableName = req.getParameter("table"+i);
			
			if(code != "" && tableName != ""){
				dao.setIn_stu(code, tableName);
				value += code+"="+tableName+",";	
			}
		}
		value = value.substring(0,value.lastIndexOf(","));
		stu.setAllcode(value);
		int result = dao.setStu(stu);

		ModelAndView mv = new ModelAndView();
		
		if(result == 1){
			mv.setViewName("/sugang/sugangPro.jsp");
		}else{
			mv.setViewName("/sugang/sugangError.jsp");
		}
		return mv;	
	}
}
