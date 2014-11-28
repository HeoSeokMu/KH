package library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.rentDAO;
import dto.rentDTO;

@Controller
public class inputNum{
	
	@RequestMapping(value="/inputNumForm.kh", method=RequestMethod.POST)
	public ModelAndView formPro(MultipartHttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
		
		System.out.println(req.getParameter("b_name"));
		List list = new ArrayList();
		/*session.setAttribute("memId", dto.getId());
		session.removeAttribute(arg0);
		session.invalidate();*/
		rentDAO dbPro = rentDAO.getInstance();
		list = dbPro.getNum();
		for(int i = 0 ; i<list.size() ; i++) {
			String a = (String) list.get(i);
			System.out.println(a);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/library/inputNumForm.jsp");
		return mv;
	}
}