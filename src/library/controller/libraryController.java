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


	
	//������ �������� ��
		@RequestMapping(value="libraryNoticeForm.kh")
		public String libraryNotice(){
			
			
			return "/library/libraryNoticeForm.jsp";
		}
	//������ �������� ó��
		@RequestMapping(value="libraryNoticeFormPro.kh")
		public String libraryNoticeFormPro(HttpSession session, HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
			MemberDAO m_dao = MemberDAO.getInstance();
			String id = (String)session.getAttribute("memId");
			
			dto.setReg_date(new Timestamp(System.currentTimeMillis()));
			
			String FileUploadPath = "/Users/Parkjongheon/git/KH/WebContent/upload/librarNotice/";
			
			bookInsertDAO notice_dao = bookInsertDAO.getInstance();
			
			//���� ���ε�
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
	
	
	return "redirect:libraryAdmin.kh";
}

//å��û�ϱ�
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

//å ��û ó��
@RequestMapping(value="/bookRequestPro.kh")
public ModelAndView bookRequestPro(HttpSession session,HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
	
	String id = (String)session.getAttribute("memId");
	
	dto.setReg_date(new Timestamp(System.currentTimeMillis()));

	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	
	//å ��ȣ �ڵ� ����
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
//��û�� å ����
@RequestMapping("/bookRequestDelete.kh")
public String bookRequestDelete(HttpSession session, HttpServletRequest req) throws Exception{
	String id = (String)session.getAttribute("memId");
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String bookid = req.getParameter("book_id");
	libraryDTO book = book_dao.bookRequestDelete(bookid);
	
	
	return "redirect:bookRequest.kh";
}
//��û�� å ����
@RequestMapping("/myBookRequestDelete.kh")
public String myBookRequestDelete(HttpSession session, HttpServletRequest req) throws Exception{
	String id = (String)session.getAttribute("memId");
	
	bookInsertDAO book_dao = bookInsertDAO.getInstance();
	String bookid = req.getParameter("book_id");
	libraryDTO book = book_dao.bookRequestDelete(bookid);
	
	
	return "redirect:libraryMain.kh";
}

//��û���� ���ó��
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
	int totalCount; 		// �� �Խù��� ��
	int blockCount = 10;	// �� ��������  �Խù��� ��
	int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	String pagingHtml; 	//����¡�� ������ HTML
	pagingAction page; 	// ����¡ Ŭ����
	
	// �Խ��� LIST �׼�
	
		bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
		// ��� ���� ������ list�� �ִ´�.
		list = dbPro.getRequestArticles();
		if(list == null){
			totalCount = 0;
		}else{
			totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		if(list != null){
			list = list.subList(page.getStartCount(), lastCount);
		}else{
			list = Collections.emptyList();
		}
		
		
		
	//�ش� �信�� ����� �Ӽ�
	ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.addObject("totalCount", totalCount);
    mv.addObject("currentPage", currentPage);
    mv.addObject("pagingHtml", pagingHtml);
 
	
	mv.setViewName("/library/bookRequestList.jsp");
	return mv;
}


//���ǽ�û���� ���ó��
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
	
	int totalCount; 		// �� �Խù��� ��
	int blockCount = 10;	// �� ��������  �Խù��� ��
	int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	String pagingHtml; 	//����¡�� ������ HTML
	pagingAction page; 	// ����¡ Ŭ����
	
	// �Խ��� LIST �׼�
	
		bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
		// ��� ���� ������ list�� �ִ´�.
		list = dbPro.getRequestArticles(id);
		if(list == null){
			totalCount = 0;
		}else{
			totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		if(list != null){
			list = list.subList(page.getStartCount(), lastCount);
		}else{
			list = Collections.emptyList();
		}
		
		
		
	//�ش� �信�� ����� �Ӽ�
	ModelAndView mv = new ModelAndView();
  mv.addObject("list", list);
  mv.addObject("totalCount", totalCount);
  mv.addObject("currentPage", currentPage);
  mv.addObject("pagingHtml", pagingHtml);

	
	mv.setViewName("/library/myBookRequestList.jsp");
	return mv;
}

//å ��� ��
	@RequestMapping(value="libraryList.kh")
	public String libraryList(){
		
		return "/library/library.jsp";
	}
	
	//��û���� ���ó��
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
		int totalCount; 		// �� �Խù��� ��
		int blockCount = 10;	// �� ��������  �Խù��� ��
		int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
		String pagingHtml; 	//����¡�� ������ HTML
		pagingAction page; 	// ����¡ Ŭ����
		
		// �Խ��� LIST �׼�
		
			bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
			// ��� ���� ������ list�� �ִ´�.
			list = dbPro.getArticles(searchType, keyword);
			if(list == null){
				totalCount = 0;
			}else{
				totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
			}
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
			pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

			// ���� ���������� ������ ������ ���� ��ȣ ����.
			int lastCount = totalCount;

			// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
			if(list != null){
				list = list.subList(page.getStartCount(), lastCount);
			}else{
				list = Collections.emptyList();
			}
			
			
			
		//�ش� �信�� ����� �Ӽ�
		ModelAndView mv = new ModelAndView();
	    mv.addObject("list", list);
	    mv.addObject("totalCount", totalCount);
	    mv.addObject("currentPage", currentPage);
	    mv.addObject("pagingHtml", pagingHtml);
	 
		
		mv.setViewName("/library/libraryAdmin.jsp");
		return mv;
	}
	//å��û ����
	@RequestMapping("/bookRequestOk.kh")
	public String bookRequestOk(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int id = Integer.parseInt(req.getParameter("book_id")); 
	
		libraryDTO book = book_dao.bookRequestOk(id);
		
		return "redirect:bookRequestList.kh";
	}
	
	
	
	//å��û �ݷ�
	@RequestMapping("/bookRequestNo.kh")
	public String bookRequestNo(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int id = Integer.parseInt(req.getParameter("book_id")); 
	
		libraryDTO book = book_dao.bookRequestNo(id);
		
		return "redirect:bookRequestList.kh";
	}
	
	//������ �������� ����Ʈ
	@RequestMapping(value="/libraryNoticeList.kh")
	public ModelAndView libraryNoticeList(HttpServletRequest req) throws Exception{
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		String pageNum = req.getParameter("currentPage");
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DAY_OF_MONTH, -7); 
		Date date = calendar.getTime(); 
		//date�� �������� Date ��ü �Դϴ�. 
	
		String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		if (pageNum == null) {
			pageNum = "1";
	    }
		
		List<libraryDTO> list = new ArrayList<libraryDTO>();	 
		int currentPage = Integer.parseInt(pageNum);
		int totalCount; 		// �� �Խù��� ��
		int blockCount = 10;	// �� ��������  �Խù��� ��
		int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
		String pagingHtml; 	//����¡�� ������ HTML
		pagingAction page; 	// ����¡ Ŭ����
		
		// �Խ��� LIST �׼�
		
			bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
			// ��� ���� ������ list�� �ִ´�.
			list = dbPro.getNoticeArticles();
			if(list == null){
				totalCount = 0;
			}else{
				totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
			}
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
			pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

			// ���� ���������� ������ ������ ���� ��ȣ ����.
			int lastCount = totalCount;

			// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
			if(list != null){
				list = list.subList(page.getStartCount(), lastCount);
			}else{
				list = Collections.emptyList();
			}
			
			
			
		//�ش� �信�� ����� �Ӽ�
		ModelAndView mv = new ModelAndView();
	    mv.addObject("list", list);
	    mv.addObject("totalCount", totalCount);
	    mv.addObject("currentPage", currentPage);
	    mv.addObject("pagingHtml", pagingHtml);
	    mv.addObject("now", now);
	 
		
		mv.setViewName("/library/libraryNoticeList.jsp");
		return mv;
	}
	//������ ���� 
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
			int totalCount; 		// �� �Խù��� ��
			int blockCount = 5;	// �� ��������  �Խù��� ��
			int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
			String pagingHtml; 	//����¡�� ������ HTML
			pagingAction page; 	// ����¡ Ŭ����
			
			// �Խ��� LIST �׼�
			
				bookInsertDAO dbPro = bookInsertDAO.getInstance(); 
				// ��� ���� ������ list�� �ִ´�.
				list = dbPro.getNoticeArticles();
				if(list == null){
					totalCount = 0;
				}else{
					totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
				}
				page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
				pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

				// ���� ���������� ������ ������ ���� ��ȣ ����.
				int lastCount = totalCount;

				// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
				if (page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;

				// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
				if(list != null){
					list = list.subList(page.getStartCount(), lastCount);
				}else{
					list = Collections.emptyList();
				}
				
				
				
			//�ش� �信�� ����� �Ӽ�
			ModelAndView mv = new ModelAndView();
		    mv.addObject("list", list);
		    mv.addObject("totalCount", totalCount);
		    mv.addObject("currentPage", currentPage);
		    mv.addObject("pagingHtml", pagingHtml);
		 
			
			mv.setViewName("/library/libraryMain.jsp");
			return mv;
		}
		
		//�������� ���� ����
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
	//�������� ���� ����
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
	//�������� ���� ó��
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

	//�������� ����
	@RequestMapping("/libraryNoticeDelete.kh")
	public String libraryNoticeDelete(HttpServletRequest req) throws Exception{
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		int no = Integer.parseInt(req.getParameter("no"));
		libraryDTO book = book_dao.libraryNoticeDelete(no);
		
		
		return "redirect:libraryNoticeList.kh";
	}


}
