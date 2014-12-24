package library.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.bookDAO;
import dao.bookInsertDAO;
import dto.libraryDTO;
import dto.memberDTO;


@Controller
public class libraryController {


	
	//도서관 공지사항 폼
		@RequestMapping(value="libraryNoticeForm.kh")
		public String libraryNotice(){
			
			
			return "/library/libraryNoticeForm.jsp";
		}
	//도서관 공지사항 처리
		@RequestMapping(value="libraryNoticeFormPro.kh")
		public String libraryNoticeFormPro(HttpSession session, HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
			MemberDAO m_dao = MemberDAO.getInstance();
			String id = (String)session.getAttribute("memId");
			
			dto.setReg_date(new Timestamp(System.currentTimeMillis()));
			
			String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/librarNotice/";
			
			bookInsertDAO notice_dao = bookInsertDAO.getInstance();
			
			//파일 업로드
			if(!request.getFile("upload").isEmpty()){
				MultipartFile file = request.getFile("upload");
			}
			
			notice_dao.libraryNotice(dto);
			
//			ModelAndView mv = new ModelAndView();
//			
//			mv.addObject("dto", dto);
//			mv.addObject("no", request.getParameter("no"));
//			mv.addObject("subject", request.getParameter("subject"));
//			mv.addObject("content", request.getParameter("content"));
//			mv.addObject("libraryfile", request.getParameter("libraryfile"));
//			mv.addObject("readhit", request.getParameter("readhit"));
//			mv.addObject("writer", request.getParameter("writer"));
//			mv.setViewName("/library/libraryNoticeForm.kh");
			
			return "redirect:libraryMain.kh";
		}
		
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
	
	
	return "redirect:libraryAdmin.kh";
}

//책신청하기
@RequestMapping(value="bookRequest.kh")
public ModelAndView bookrequest(HttpSession session, HttpServletRequest req) throws Exception{
	
	MemberDAO m_dao = MemberDAO.getInstance();
	String id = (String)session.getAttribute("memId");
	memberDTO mDTO = m_dao.member_info(id);
	String name = mDTO.getName();
	String s_phone = mDTO.getS_phone();
	ModelAndView mv = new ModelAndView();
	mv.addObject("mDTO", mDTO);
	mv.addObject("id", id);
	mv.addObject("name", name);
	mv.addObject("s_phone", s_phone);
	
	mv.setViewName("/library/bookRequest.jsp");
	
	return mv;
}

//책 신청 처리
@RequestMapping(value="/bookRequestPro.kh")
public ModelAndView bookRequestPro(HttpSession session,HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
	
	String id = (String)session.getAttribute("memId");
	
	dto.setReg_date(new Timestamp(System.currentTimeMillis()));

	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	
	//책 번호 자동 증가
	int num = book_dao.requestNum()+1;
	dto.setId(id);
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
public String bookRequestDelete(HttpSession session, HttpServletRequest req) throws Exception{
	String id = (String)session.getAttribute("memId");
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String bookid = req.getParameter("book_id");
	libraryDTO book = book_dao.bookRequestDelete(bookid);
	
	
	return "redirect:bookRequest.kh";
}
//신청한 책 삭제
@RequestMapping("/myBookRequestDelete.kh")
public String myBookRequestDelete(HttpSession session, HttpServletRequest req) throws Exception{
	String id = (String)session.getAttribute("memId");
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String bookid = req.getParameter("book_id");
	libraryDTO book = book_dao.bookRequestDelete(bookid);
	
	
	return "redirect:libraryMain.kh";
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
		list = dbPro.getRequestArticles();
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
public ModelAndView myRequestList(HttpSession session, HttpServletRequest req) throws Exception{
	
	
	String searchType = req.getParameter("searchType");
	String keyword = req.getParameter("keyword");
	String pageNum = req.getParameter("currentPage");
	
	if (pageNum == null) {
		pageNum = "1";
  }
	
	List<libraryDTO> list = new ArrayList<libraryDTO>();	 
	int currentPage = Integer.parseInt(pageNum);
	String id =  (String)session.getAttribute("memId");
	
	int totalCount; 		// 총 게시물의 수
	int blockCount = 10;	// 한 페이지의  게시물의 수
	int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	String pagingHtml; 	//페이징을 구현한 HTML
	pagingAction page; 	// 페이징 클래스
	
	// 게시판 LIST 액션
	
		bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
		// 모든 글을 가져와 list에 넣는다.
		list = dbPro.getRequestArticles(id);
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

//책 등록 폼
	@RequestMapping(value="libraryList.kh")
	public String libraryList(){
		
		return "/library/library.jsp";
	}
	
	//신청내역 목록처리
	@RequestMapping(value="/libraryAdmin.kh")
	public ModelAndView libraryAdmin(HttpServletRequest req) throws Exception{
		
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
			list = dbPro.getArticles(searchType, keyword);
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
	 
		
		mv.setViewName("/library/libraryAdmin.jsp");
		return mv;
	}
	//책신청 승인
	@RequestMapping("/bookRequestOk.kh")
	public String bookRequestOk(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int id = Integer.parseInt(req.getParameter("book_id")); 
	
		libraryDTO book = book_dao.bookRequestOk(id);
		
		return "redirect:bookRequestList.kh";
	}
	
	
	
	//책신청 반려
	@RequestMapping("/bookRequestNo.kh")
	public String bookRequestNo(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int id = Integer.parseInt(req.getParameter("book_id")); 
	
		libraryDTO book = book_dao.bookRequestNo(id);
		
		return "redirect:bookRequestList.kh";
	}
	
	//도서관 공지사항 리스트
	@RequestMapping(value="/libraryNoticeList.kh")
	public ModelAndView libraryNoticeList(HttpServletRequest req) throws Exception{
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		String pageNum = req.getParameter("currentPage");
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DAY_OF_MONTH, -7); 
		Date date = calendar.getTime(); 
		//date가 일주일전 Date 객체 입니다. 
	
		String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
		
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
			list = dbPro.getNoticeArticles();
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
	    mv.addObject("now", now);
	 
		
		mv.setViewName("/library/libraryNoticeList.jsp");
		return mv;
	}
	//도서관 메인 
		@RequestMapping(value="/libraryMain.kh")
		public ModelAndView libraryMainNoticeList(HttpServletRequest req,HttpSession session) throws Exception{
			
			String searchType = req.getParameter("searchType");
			String keyword = req.getParameter("keyword");
			String pageNum = req.getParameter("currentPage");
			String id = (String)session.getAttribute("memId");
			
			if (pageNum == null) {
				pageNum = "1";
		    }
			
			List<libraryDTO> list = new ArrayList<libraryDTO>();	 
			int currentPage = Integer.parseInt(pageNum);
			int totalCount; 		// 총 게시물의 수
			int blockCount = 5;	// 한 페이지의  게시물의 수
			int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
			String pagingHtml; 	//페이징을 구현한 HTML
			pagingAction page; 	// 페이징 클래스
			
			// 게시판 LIST 액션
			
				bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
				// 모든 글을 가져와 list에 넣는다.
				list = dbPro.getNoticeArticles();
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
		 
			
			mv.setViewName("/library/libraryMain.jsp");
			return mv;
		}
		
		//공지사항 내역 보기
		@RequestMapping("/libraryNoticeView.kh")
		public ModelAndView libraryNoticeView(HttpServletRequest req,HttpSession session, @ModelAttribute libraryDTO dto) throws Exception{
			
			String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/libraryNotice/";
				
			String id = (String)session.getAttribute("memId");
			bookInsertDAO book_dao = bookInsertDAO.getInstance();
			int no = Integer.parseInt(req.getParameter("no"));
			
			
			libraryDTO notice = book_dao.getNoticeView(no);
			
			
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("notice", notice);
			
			mv.setViewName("/library/libraryNoticeView.jsp");
			
			return mv;
		}
	//공지사항 내용 수정
		@RequestMapping("/libraryNoticeModify.kh")
		public ModelAndView libraryNoticeModify(HttpServletRequest req) throws Exception{
			
			bookInsertDAO book_dao = bookInsertDAO.getInstance();
			int no = Integer.parseInt(req.getParameter("no"));
			libraryDTO notice = book_dao.noticeView(no);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("notice", notice);
			mv.setViewName("/library/libraryNoticeModify.jsp");
			
			return mv;
	}
	//공지사항 수정 처리
	@RequestMapping("/libraryNoticeModifyFormPro.kh")
	public String libraryNoticeModifyFormPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
		
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));

		String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/libraryNotice/";
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		
		if(!request.getFile("upload").isEmpty()){
			MultipartFile file = request.getFile("upload");
		}
			
		book_dao.libraryNoticeModify(dto);
		return "redirect:libraryNoticeList.kh";
		}

	//공지사항 삭제
	@RequestMapping("/libraryNoticeDelete.kh")
	public String libraryNoticeDelete(HttpServletRequest req) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int no = Integer.parseInt(req.getParameter("no"));
		libraryDTO book = book_dao.libraryNoticeDelete(no);
		
		
		return "redirect:libraryNoticeList.kh";
	}


}
