package library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class inputNum{
	
	@RequestMapping(value="/inputNumForm.kh", method=RequestMethod.GET)
	public ModelAndView numInputForm(HttpServletRequest req) throws Exception{
		String book_id = req.getParameter("book_id");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/library/inputNumForm.jsp");
		mv.addObject("book_id", book_id);
		return mv;
	}

	/*@RequestMapping(value="/inputNumPro.kh", method=RequestMethod.POST)
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
		System.out.println(dto.getS_num());
		
		//현재 시간을 불러와 14일 뒤 날짜로 저장(반납 날짜)
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH, date.get(Calendar.MONTH));
		date.set(Calendar.DATE, date.get(Calendar.DATE)+14);
		date.set(Calendar.HOUR_OF_DAY, 18);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		java.util.Date uDate = date.getTime();		//calender -> util.date 형변환
		java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());	//util.date -> Timestamp 변환
		dto.setTurnin(tDate);
		
		rentDAO dbPro = rentDAO.getInstance();	//인스턴스값 받아옴
		dbPro.insertRent(dto);
		
		//대여체크 넣을자리
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
	}*/
}
