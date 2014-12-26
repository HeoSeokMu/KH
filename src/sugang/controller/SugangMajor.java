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
		
		codelist = dao.getCode(semester, stu_num); // �ڵ� ��������

		String code = req.getParameter("m_code");
		int grade = Integer.parseInt(req.getParameter("y_grade"));
	
		sugangList = dao.getList(code, grade);

		for(sugangDTO dto: sugangList){
			
			String y = dto.getL_type();
			if(y.equals("e")){
				dto.setL_type("�� ��");
			}else{
				dto.setL_type("�� ��");
			}
			
			String z = dto.getL_day();
			switch(z){
				case "��" : dto.setDay(100); break;
				case "ȭ" : dto.setDay(200); break;
				case "��" : dto.setDay(300); break;
				case "��" : dto.setDay(400); break;
				case "��" : dto.setDay(500); break;
			}	

		}
		
		
		ModelAndView mv = new ModelAndView();
		
		if(codelist != null){
			mv.addObject("codelist",codelist); //��û�� ���� ����Ʈ
			mv.addObject("stu",stu); // �л� ����
		}
		mv.addObject("sugangList",sugangList);
		mv.setViewName("/sugang/major.jsp");
		return mv;
	}
}
