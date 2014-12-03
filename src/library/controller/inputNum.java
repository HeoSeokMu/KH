package library.controller;


import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.rentDAO;
import dto.rentDTO;



@Controller
public class inputNum{
	
	@RequestMapping(value="/inputNumForm.kh", method=RequestMethod.POST)
	public ModelAndView form(HttpServletRequest req) throws Exception{
		String b_num = req.getParameter("b_num");
		String b_name = req.getParameter("b_name");
		System.out.println(b_num);

		ModelAndView mv = new ModelAndView();

		mv.addObject("b_num", b_num);		//å��ȣ�� ������ �Ķ���ͷ� ������
		mv.addObject("b_name", b_name);
		mv.setViewName("/library/inputNumForm.jsp");
		return mv;
	}

	@RequestMapping(value="/inputNumPro.kh", method=RequestMethod.POST)
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
		System.out.println(dto.getS_num());
		
		//���� �ð��� �ҷ��� 14�� �� ��¥�� ����(�ݳ� ��¥)
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH, date.get(Calendar.MONTH));
		date.set(Calendar.DATE, date.get(Calendar.DATE)+14);
		date.set(Calendar.HOUR_OF_DAY, 18);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		java.util.Date uDate = date.getTime();		//calender -> util.date ����ȯ
		java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());	//util.date -> Timestamp ��ȯ
		dto.setTurnin(tDate);
		
		rentDAO dbPro = rentDAO.getInstance();	//�ν��Ͻ��� �޾ƿ�
		dbPro.insertRent(dto);
		
		//�뿩üũ �����ڸ�
		//
		//
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("tDate",tDate);
		mv.addObject("b_name", req.getParameter("b_name"));
		mv.addObject("s_name", req.getParameter("s_name"));
		mv.addObject("s_phone", req.getParameter("s_phone"));
		
		mv.setViewName("/library/inputNumPro.jsp");
		return mv;
	}
}
