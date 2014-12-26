package library.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.libraryDTO;
import dto.reserveDTO;

@Controller
public class noticeList {
	@RequestMapping(value="/noticeList.kh")
	public ModelAndView noticeList(HttpSession session){
		String memId = (String) session.getAttribute("memId");
		List<reserveDTO> list = new ArrayList<reserveDTO>();
		ModelAndView mv = new ModelAndView();
		
		bookDAO dbPro = bookDAO.getInstance();
		int i = dbPro.getNoticeListCount(memId);
		if(i>0){
			list = dbPro.getNoticeList(memId);
			mv.addObject("list", list);
		}
		mv.addObject("totalCount", i);
		mv.setViewName("/library/noticeList.jsp");
		return mv;
	}
	
	@RequestMapping(value="/noticeDelete.kh")
	public ModelAndView noticeDelete(HttpServletRequest req, HttpSession session){
		String memId = (String) session.getAttribute("memId");
		String b_num = req.getParameter("b_num");
		
		bookDAO dbPro = bookDAO.getInstance();
		dbPro.noticeDelete(memId, b_num);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/noticeList.kh");
		return mv;
	}
}
