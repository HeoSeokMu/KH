package library.controller;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dto.libraryDTO;


@Controller
public class libraryController {

	//å ��� ��
	@RequestMapping(value="bookInsertForm.kh")
	public String form(){
		
		return "/library/bookInsertForm.jsp";
	}
	
	
	//å ��� ó��
	@RequestMapping(value="/bookInsertFormPro.kh")
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/book_img/";
		

		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		
		//å ��ȣ �ڵ� ����
		int num = book_dao.plusNum()+1;
		dto.setBook_id(num);
		
		//���� ���ε�
		if(!request.getFile("upload").isEmpty()){
			MultipartFile file = request.getFile("upload");

			//���ϸ��� Ȯ���� ����.
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().
					length()-3, file.getOriginalFilename().length());
			
			//ID.Ȯ���� ���·� ���ϸ� �����.
			String fileName = dto.getBook_id() + "." + extension;
			File saveFile = new File(FileUploadPath + fileName);
			try{
				file.transferTo(saveFile);
			}catch(Exception e){
				e.printStackTrace();
			}
			dto.setBook_img(fileName);
		
			}
		
		
		book_dao.bookInsert(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("book_id", req.getParameter("book_id"));
		mv.addObject("book_title", req.getParameter("book_title"));
		mv.addObject("book_location", req.getParameter("book_location"));
		mv.addObject("book_writer", req.getParameter("book_writer"));
		mv.addObject("book_publisher", req.getParameter("book_publisher"));
		mv.addObject("book_supplment", req.getParameter("book_supplement"));
		mv.addObject("book_img", req.getParameter("book_img"));
		mv.addObject("book_year", req.getParameter("book_year"));
		mv.addObject("isbn", req.getParameter("isbn"));
		
		
		
		
		mv.setViewName("/library/bookInsertFormPro.jsp");
		
		return mv;
	}
	
	//����� å ����
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
//å ���� ó��
@RequestMapping("/bookModifyFormPro.kh")
public ModelAndView bookModifyFormPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
	
	dto.setReg_date(new Timestamp(System.currentTimeMillis()));

	String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/book_img/";
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	
	if(!request.getFile("upload").isEmpty()){
		MultipartFile file = request.getFile("upload");

		//���ϸ��� Ȯ���� ����.
		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().
				length()-3, file.getOriginalFilename().length());
		
		//ID.Ȯ���� ���·� ���ϸ� �����.
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

//����� å ���� ����
@RequestMapping("/bookView.kh")
public ModelAndView bookView(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
	
	String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/book_img/";
		
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String id = req.getParameter("book_id");

	
	libraryDTO book = book_dao.getBookView(id);
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("book", book);
	
	mv.setViewName("/library/bookView.jsp");
	
	return mv;
}

//����� å ����
@RequestMapping("/bookDelete.kh")
public String bookDelete(HttpServletRequest req) throws Exception{
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String id = req.getParameter("book_id");
	libraryDTO book = book_dao.bookDelete(id);
	
	
	return "redirect:bookInsertForm.kh";
}

}
