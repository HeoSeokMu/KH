package member.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dao.MemberDAO;
import dto.noticeboard_DTO;

@Controller
public class notice_board {
	private static List<noticeboard_DTO> list = new ArrayList<noticeboard_DTO>();
	
	private int currentPage = 1;	// 현재 페이지
	private int totalCount;			// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 10; 	// 한 화면에 보여줄 페이지 수
	private pagingAction page; 		// 페이징 클래스
	private String pagingHtml; 		// 페이징을 구현한 HTML
	
	@RequestMapping(value="/notice_board.kh")
	public ModelAndView notice_board(HttpServletRequest req) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		list = mDAO.notice_BoardList();
		
		if(list == null){
			ModelAndView mv = new ModelAndView();
			mv.addObject("totalCount", 0);
			mv.setViewName("/member/notice_board.jsp");
			
			return mv;
		}
		
		totalCount = list.size(); // 전체 글 갯수를 구한다.
		
		String currentPage_check = req.getParameter("currentPage");
		if(currentPage_check == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
			
		pagingHtml = page.getPagingHtml().toString();  // 페이지 HTML 생성.
	
		//paging
		int lastCount = totalCount;
			
		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("totalCount", totalCount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("pagingHtml", pagingHtml);
		mv.addObject("blockCount", blockCount);
		mv.setViewName("/member/notice_board.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/writeNotice_board.kh")
	public ModelAndView writeform(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String name;
		String id = (String) session.getAttribute("memId");
		MemberDAO mDAO = MemberDAO.getInstance();
		
		name = mDAO.getName(id);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);
		mv.setViewName("/member/content.jsp");
		return mv;
	}
	
	@RequestMapping("/writeNotice_boardPro.kh")
	public ModelAndView writeformPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute noticeboard_DTO nb_DTO) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		nb_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea의 줄바꿈 태그를 교체.
		String content = nb_DTO.getContent();
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll("\u0020", "&nbsp;");
		nb_DTO.setContent(content);
		
		mDAO.insert_NoticeBoard(nb_DTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nb_DTO", nb_DTO);
		
		mv.setViewName("redirect:/notice_board.kh");
		
		return mv;
	}
	
	@RequestMapping("/notice_boardView.kh")
	public ModelAndView contentView(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute noticeboard_DTO nb_DTO) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		int num = 0;
		num = (Integer.parseInt(request.getParameter("num")));
		
		
		
		ModelAndView mv = new ModelAndView();
		noticeboard_DTO article = mDAO.getArticle(num);
		
		String content = article.getContent();
		content = content.replaceAll("<br>", "\r\n");
		content = content.replaceAll("&nbsp;", "\u0020");
		
		article.setContent(content);
		
		mv.addObject("article", article);
		
		mv.setViewName("/member/content.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/modifyNotice_board.kh")
	public ModelAndView modifyForm(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String name;
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = (String) session.getAttribute("memId");
		MemberDAO mDAO = MemberDAO.getInstance();
		
		name = mDAO.getName(id);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);
		mv.addObject("title", title);
		mv.addObject("content", content);
		mv.addObject("num", num);
		mv.setViewName("/member/content.jsp");
		return mv;
	}
	
	@RequestMapping(value="/modifyNotice_boardPro.kh")
	public ModelAndView modifyFormPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, @ModelAttribute noticeboard_DTO nb_DTO) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		nb_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea의 줄바꿈 태그를 교체.
		String content = request.getParameter("content");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll("\u0020", "&nbsp;");
		nb_DTO.setContent(content);
		
		mDAO.modifyArticle(nb_DTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nb_DTO", nb_DTO);
		mv.setViewName("redirect:/notice_board.kh");
		return mv;
	}
	
	@RequestMapping("/deleteNotice_board.kh")
	public ModelAndView deleteNotice_board(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute noticeboard_DTO nb_DTO) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		int num = (Integer.parseInt(request.getParameter("num")));

		System.out.println(num);
		ModelAndView mv = new ModelAndView();
		noticeboard_DTO article = mDAO.deleteArticle(num);
		
		mv.addObject("article", article);
		
		mv.setViewName("redirect:/notice_board.kh");
		
		return mv;
	}
	
}