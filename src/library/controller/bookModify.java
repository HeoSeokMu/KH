package library.controller;


import java.io.File;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;

@Controller
public class bookModify {
	
		
		@RequestMapping("/bookModifyForm.kh")
		public ModelAndView bookView(HttpServletRequest req) throws Exception{
			
			bookInsertDAO book_dao = bookInsertDAO.getInstance();
			String id = req.getParameter("book_id");
			libraryDTO book = book_dao.getBookView(id);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("book", book);
			
			mv.setViewName("/library/bookModifyForm.jsp");
			
			return mv;
	}
	
	@RequestMapping("/bookModifyFormPro.kh")
	public ModelAndView bookModifyFormPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/book_img/";
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		
		if(!request.getFile("upload").isEmpty()){
			MultipartFile file = request.getFile("upload");

			//파일명에서 확장자 추출.
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().
					length()-3, file.getOriginalFilename().length());
			
			//ID.확장자 형태로 파일명 만들기.
			String fileName = dto.getBook_id() + "." + extension;
			File saveFile = new File(FileUploadPath + fileName);
			try{
				file.transferTo(saveFile);
			}catch(Exception e){
				e.printStackTrace();
			}
			dto.setBook_img(fileName);
		
			}
		
		book_dao.bookModify(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("book_id", req.getParameter("book_id"));
		mv.addObject("book_title", req.getParameter("book_title"));
		mv.addObject("book_location", req.getParameter("book_location"));
		mv.addObject("book_writer", req.getParameter("book_writer"));
		mv.addObject("book_publisher", req.getParameter("book_publisher"));
		mv.addObject("book_supplment", req.getParameter("book_supplement"));
		mv.addObject("book_img", req.getParameter("book_img"));
		mv.addObject("isbn", req.getParameter("isbn"));
		mv.setViewName("/library/bookModifyFormPro.jsp");
		
		return mv;
	}
}
