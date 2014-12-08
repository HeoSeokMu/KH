package member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.noticeboard_DTO;

@Controller
public class notice_board {
	private static List<noticeboard_DTO> list = new ArrayList<noticeboard_DTO>();
	
	private int currentPage = 1;	// 현재 페이지
	private int totalCount;			// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 5; 		// 한 화면에 보여줄 페이지 수
	private pagingAction page; 		// 페이징 클래스
	private String pagingHtml; 		// 페이징을 구현한 HTML
	
	@RequestMapping(value="/notice_board.kh")
	public ModelAndView notice_board(HttpServletRequest req) throws Exception{
		
		System.out.println("notice_board =================== : ");
		
		MemberDAO mDAO = MemberDAO.getInstance();
		list = mDAO.notice_BoardList();
		totalCount = list.size(); // 전체 글 갯수를 구한다.
		
		System.out.println("totalCount : " + totalCount);
				
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
			
		System.out.println("list f : " + list);
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
		mv.addObject("pagingHtml", pagingHtml);
		mv.setViewName("/member/notice_board.jsp");
		
		System.out.println(mv.getViewName());
		
		return mv;
	}
}