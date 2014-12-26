package sugang.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.sugangDAO;
import dto.stuDTO;
import dto.sugangDTO;

@Controller
public class SugangMajor {
	
	@RequestMapping(value="/selectMajor.kh")
	public ModelAndView form(HttpServletRequest req) throws SQLException{
		
		stuDTO stu = new stuDTO();
		
		List<sugangDTO> sugangList = new ArrayList<sugangDTO>();
		List<String> codelist = new ArrayList<String>();
		
		sugangDAO dao = sugangDAO.getInstance();
		
		String stu_num = req.getParameter("stu_num");
		String semester = req.getParameter("semester");
		
		codelist = dao.getCode(semester, stu_num); // 코드 가져오기

		String code = req.getParameter("m_code");
		int grade = Integer.parseInt(req.getParameter("y_grade"));
	
		sugangList = dao.getList(code, grade);

		for(sugangDTO dto: sugangList){
			
			String y = dto.getL_type();
			if(y.equals("e")){
				dto.setL_type("전 필");
			}else{
				dto.setL_type("전 선");
			}
			
			String z = dto.getL_day();
			switch(z){
				case "월" : dto.setDay(100); break;
				case "화" : dto.setDay(200); break;
				case "수" : dto.setDay(300); break;
				case "목" : dto.setDay(400); break;
				case "금" : dto.setDay(500); break;
			}	

		}
		
		
		ModelAndView mv = new ModelAndView();
		
		if(codelist != null){
			mv.addObject("codelist",codelist); //신청한 학점 리스트
			mv.addObject("stu",stu); // 학생 정보
		}
		mv.addObject("sugangList",sugangList);
		mv.setViewName("/sugang/major.jsp");
		return mv;
	}
}
