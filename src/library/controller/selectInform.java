package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.memberDTO;

@Controller
public class selectInform {
	@RequestMapping(value="/selectInform.kh", method=RequestMethod.GET)
	public ModelAndView select(HttpServletRequest req) throws Exception{
		String s_num = req.getParameter("num");
		String book_id = req.getParameter("book_id");
		String book_title = req.getParameter("book_title");
		String id_check = req.getParameter("id_check");
		
		memberDTO dto = new memberDTO();
		bookDAO dbPro = bookDAO.getInstance();
		dto = dbPro.getSelectInform(s_num);
		
		ModelAndView mv = new ModelAndView();
		
		if(dto.getS_phone() == null){
			mv.addObject("check", "check");
		}else{
			int i = dto.getS_phone().indexOf("]") + 1;	//통신사 잘라내기
			String phone = dto.getS_phone().substring(i);
			mv.addObject("s_phone", phone);
			mv.addObject("check", null);
		}
		
		mv.setViewName("/library/inputNumForm.jsp");
		mv.addObject("s_num", s_num);
		mv.addObject("book_id", book_id);
		mv.addObject("book_title", book_title);
		mv.addObject("s_name", dto.getName());
		mv.addObject("id_check", id_check);
		return mv;
	}

}
