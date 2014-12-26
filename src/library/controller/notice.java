package library.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dao.reserveDAO;
import dto.reserveDTO;

@Controller
public class notice {
	

		@RequestMapping(value="/notice.kh")
		public ModelAndView reserve(HttpServletRequest req, @ModelAttribute reserveDTO dto) throws Exception{
			
			Calendar date = Calendar.getInstance();
			java.util.Date uDate = date.getTime();		//calender -> util.date ����ȯ
			java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());	//util.date -> Timestamp ��ȯ
			dto.setRent(tDate);	//����ð� �Է�
			
			System.out.println(dto.getB_num());
			System.out.println(dto.getS_num());
			
			bookDAO dbPro = bookDAO.getInstance();
			dto.setEmail(dbPro.getEmail(dto.getS_num()));		//����� email �Է�
			dbPro.insertNotice(dto);
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("/library/notice.jsp");
			return mv;
		}
}
