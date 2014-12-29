package sugang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.hakjumDAO;
import dto.hakjumDTO;

@Controller
public class HakjumController {

	@RequestMapping(value="/hakjumForm.kh")
	public ModelAndView hakjumForm(HttpSession session){
		ModelAndView mv = new ModelAndView();
		
		String code = (String) session.getAttribute("memId");
		int p_code = Integer.parseInt(code);
		//int p_code = 2014401001; // 교수 코드
		
		List<hakjumDTO> list = new ArrayList<hakjumDTO>();
		hakjumDTO dto = new hakjumDTO();
		hakjumDAO dao = hakjumDAO.getInstance();
		
		list = dao.getList(p_code);
		for(hakjumDTO hakjum : list){
			String type = dto.getType();
			if(type == "e"){
				hakjum.setType("전 필");
			}else{
				hakjum.setType("전 선");
			}
		}
		
		
		mv.addObject("list",list);
		mv.setViewName("hakjum/hakjum.jsp");
		return mv;
	}
}
