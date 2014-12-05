package library.controller;

import java.io.File;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import libraryPage.PagingAction;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import dao.bookInsertDAO;
import dto.libraryDTO;



@Controller
public class bookInsert{
	
	public static SqlMapClient sqlMapper;
	
	private libraryDTO paramClass = new libraryDTO();
	private libraryDTO resultClass = new libraryDTO();
	
	private List<libraryDTO> list = new ArrayList<libraryDTO>();
	private List<libraryDTO> topList = new ArrayList<libraryDTO>();
	
	private int currentPage = 1;	// 현재 페이지
	private int totalCount;			// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의 게시물의 수
	private int blockPage = 5;		// 한 화면에 보여줄 페이지 수
	private int topCount = 0;
	private String pagingHtml;		// 페이징을 구현한 HTML
	private PagingAction page;		// 페이징 클래스
	private String actionName = "bookInsert";
	
public static Reader reader;
	
	
	@RequestMapping(value="libraryInsertList.kh")
	public String libraryInsertList(HttpServletRequest request) throws Exception{
		libraryDTO libraryDTO = new libraryDTO();

		topList = sqlMapper.queryForList("Qna.listTopQna");		

		topCount = topList.size();		
		
		HashMap<String, String> param = new HashMap<String, String>();

			param.put("qna_category", request.getParameter("qna_category"));			
			param.put("qna_checkreply",request.getParameter("qna_checkreply"));
			param.put("searchText", request.getParameter("searchText"));

			list = sqlMapper.queryForList("Qna.listQna", param);
			
		if(request.getParameter("currentPage") == null)
		{
			currentPage = 1;
		}
		else
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		totalCount = list.size(); // 전체 글 갯수를 구한다.
		page = new PagingAction(actionName, currentPage, totalCount,blockCount, blockPage); // pagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.
		
		

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);
		

		/*
		 * for(int i=0;i<list.size();i++){ QnaDTO a = list.get(i);
		 * System.out.println("index = " + a.toString()); }
		 */

		// sqlMapper.update("Qna.updateReadCount", getQna_num());
		// resultClass = (QnaDTO)sqlMapper.queryForObject("Qna.qnaDetail",
		// getQna_num());
		
		request.setAttribute("topList", topList);
		request.setAttribute("pagingHtml", pagingHtml);
		request.setAttribute("list", list);
		request.setAttribute("topCount", topCount);
		return "/library/libraryInsertList.jsp";
	}
	
	
	@RequestMapping(value="bookInsertForm.kh")
	public String form(){
		return "/library/bookInsertForm.jsp";
	}
	

	@RequestMapping(value="/bookInsertFormPro.kh")
	public ModelAndView formPro(HttpServletRequest req, @ModelAttribute libraryDTO dto, MultipartHttpServletRequest request) throws Exception{
		
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
		
		
		
		
		mv.setViewName("/library/bookInsertFormPro.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/bookInsertList.kh")
	public ModelAndView formPrp(HttpServletRequest req, @ModelAttribute libraryDTO dto) throws Exception{

		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		bookInsertDAO book_dao = bookInsertDAO.getInstance();
		book_dao.bookInsert(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("book_id", req.getParameter("book_id"));
		mv.addObject("book_title", req.getParameter("book_title"));
		mv.addObject("book_location", req.getParameter("book_location"));
		mv.addObject("book_writer", req.getParameter("book_writer"));
		mv.addObject("book_publisher", req.getParameter("book_publisher"));
		mv.addObject("book_year", req.getParameter("book_year"));
		mv.addObject("book_supplment", req.getParameter("book_supplement"));
		mv.addObject("file_orgname", req.getParameter("file_orgname"));
		
		
		mv.setViewName("/library/bookInsertList.jsp");
		
		return mv;
	}
	
}
