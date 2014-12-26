package library.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.libraryDTO;
import dto.reserveDTO;

public class noticeList {
	@RequestMapping(value="/noticeList.kh")
	public ModelAndView noticeList(MultipartHttpServletRequest req, HttpSession session){
		String memId = (String) session.getAttribute("memId");
		List<reserveDTO> list = new ArrayList<reserveDTO>();
		
		bookDAO dbPro = bookDAO.getInstance();
		list = dbPro.getNoticeList(memId);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		//mv.addObject("totalCount", totalCount);
		mv.setViewName("/library/noticeList.jsp");
		return mv;
	}
}
