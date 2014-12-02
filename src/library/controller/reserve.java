package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.rentDAO;
import dao.reserveDAO;

@Controller
public class reserve{
	
	@RequestMapping(value="/reserveForm.kh", method=RequestMethod.POST)
	public ModelAndView form(HttpServletRequest req) throws Exception{
		String reserveDate = null;
		String rentDate = null;
		String b_num = req.getParameter("b_num");
		String b_name = req.getParameter("b_name");
		
		reserveDAO reservePro = reserveDAO.getInstance();
		rentDAO rentPro = rentDAO.getInstance();
		reserveDate = reservePro.getDate(b_num);		//�������̺��� �ش� å�� ���� ��¥ ������
		rentDate = rentPro.getDate(b_num);				//�뿩���̺��� �뿩 ������ ��¥ ������
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("b_num", b_num);		//å��ȣ�� ������ �Ķ���ͷ� ������
		mv.addObject("b_name", b_name);
		mv.setViewName("/library/reserveForm.jsp");
		return mv;
	}
}