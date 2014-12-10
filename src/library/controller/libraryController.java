package library.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dao.bookInsertDAO;
import dto.libraryDTO;


@Controller
public class libraryController {

	//책 등록 폼
	@RequestMapping(value="bookInsertForm.kh")
	public String form(){
		
		return "/library/bookInsertForm.jsp";
	}
	
	
	//책 등록 처리
	@RequestMapping(value="/bookInsertFormPro.kh")
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/book_img/";
		

		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		
		//책 번호 자동 증가
		int num = book_dao.plusNum()+1;
		dto.setBook_id(num);
		
		//파일 업로드
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
	
	//등록한 책 수정
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
//책 수정 처리
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

//등록한 책 내역 보기
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

//등록한 책 삭제
@RequestMapping("/bookDelete.kh")
public String bookDelete(HttpServletRequest req) throws Exception{
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String id = req.getParameter("book_id");
	libraryDTO book = book_dao.bookDelete(id);
	
	
	return "redirect:bookInsertForm.kh";
}

//책신청하기
@RequestMapping(value="bookRequest.kh")
public String bookrequest(){
	
	return "/library/bookRequest.jsp";
}

//책 신청 처리
@RequestMapping(value="/bookRequestPro.kh")
public ModelAndView bookRequestPro(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
	
	dto.setReg_date(new Timestamp(System.currentTimeMillis()));

	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	
	//책 번호 자동 증가
	int num = book_dao.requestNum()+1;
	dto.setBook_id(num);
	
	
	book_dao.bookRequest(dto);
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("dto", dto);
	mv.addObject("book_id", req.getParameter("book_id"));
	mv.addObject("book_title", req.getParameter("book_title"));
	mv.addObject("book_writer", req.getParameter("book_writer"));
	mv.addObject("book_publisher", req.getParameter("book_publisher"));
	mv.addObject("isbn", req.getParameter("isbn"));
	
	mv.setViewName("/library/bookRequestPro.jsp");
	
	return mv;
}
//신청한 책 삭제
@RequestMapping("/bookRequestDelete.kh")
public String bookRequestDelete(HttpServletRequest req) throws Exception{
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String id = req.getParameter("book_id");
	libraryDTO book = book_dao.bookRequestDelete(id);
	
	
	return "redirect:bookRequest.kh";
}

//신청내역 목록처리
@RequestMapping(value="/bookRequestList.kh")
public ModelAndView requestList(HttpServletRequest req) throws Exception{
	
	String searchType = req.getParameter("searchType");
	String keyword = req.getParameter("keyword");
	String pageNum = req.getParameter("currentPage");
	
	if (pageNum == null) {
		pageNum = "1";
    }
	
	List<libraryDTO> list = new ArrayList<libraryDTO>();	 
	int currentPage = Integer.parseInt(pageNum);
	int totalCount; 		// 총 게시물의 수
	int blockCount = 10;	// 한 페이지의  게시물의 수
	int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	String pagingHtml; 	//페이징을 구현한 HTML
	pagingAction page; 	// 페이징 클래스
	
	// 게시판 LIST 액션
	
		bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
		// 모든 글을 가져와 list에 넣는다.
		list = dbPro.getArticles();
		if(list == null){
			totalCount = 0;
		}else{
			totalCount = list.size(); // 전체 글 갯수를 구한다.
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		if(list != null){
			list = list.subList(page.getStartCount(), lastCount);
		}else{
			list = Collections.emptyList();
		}
		
		
		
	//해당 뷰에서 사용할 속성
	ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.addObject("totalCount", totalCount);
    mv.addObject("currentPage", currentPage);
    mv.addObject("pagingHtml", pagingHtml);
 
	
	mv.setViewName("/library/bookRequestList.jsp");
	return mv;
}


//나의신청내역 목록처리
@RequestMapping(value="/myBookRequestList.kh")
public ModelAndView myRequestList(HttpServletRequest req) throws Exception{
	
	String searchType = req.getParameter("searchType");
	String keyword = req.getParameter("keyword");
	String pageNum = req.getParameter("currentPage");
	
	if (pageNum == null) {
		pageNum = "1";
  }
	
	List<libraryDTO> list = new ArrayList<libraryDTO>();	 
	int currentPage = Integer.parseInt(pageNum);
	int id =  Integer.parseInt(req.getParameter("id")); 
	int totalCount; 		// 총 게시물의 수
	int blockCount = 10;	// 한 페이지의  게시물의 수
	int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	String pagingHtml; 	//페이징을 구현한 HTML
	pagingAction page; 	// 페이징 클래스
	
	// 게시판 LIST 액션
	
		bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
		// 모든 글을 가져와 list에 넣는다.
		list = dbPro.getArticles(id);
		if(list == null){
			totalCount = 0;
		}else{
			totalCount = list.size(); // 전체 글 갯수를 구한다.
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		if(list != null){
			list = list.subList(page.getStartCount(), lastCount);
		}else{
			list = Collections.emptyList();
		}
		
		
		
	//해당 뷰에서 사용할 속성
	ModelAndView mv = new ModelAndView();
  mv.addObject("list", list);
  mv.addObject("totalCount", totalCount);
  mv.addObject("currentPage", currentPage);
  mv.addObject("pagingHtml", pagingHtml);

	
	mv.setViewName("/library/myBookRequestList.jsp");
	return mv;
}
}
