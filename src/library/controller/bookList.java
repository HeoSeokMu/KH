package library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.libraryDTO;

@Controller	
public class bookList{//글목록 처리

		@RequestMapping(value="/listTest.kh", method=RequestMethod.GET)
		public ModelAndView formPro(HttpServletRequest req) throws Exception{
			
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
				bookDAO dbPro = bookDAO.getInstance();//DB연동
				
				// 모든 글을 가져와 list에 넣는다.
				list = dbPro.getArticles(searchType, keyword);
				System.out.println(list.size());
				
				totalCount = list.size(); // 전체 글 갯수를 구한다.
				page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction 객체 생성.
				pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

				// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
				int lastCount = totalCount;

				// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
				if (page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;

				// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
				list = list.subList(page.getStartCount(), lastCount);
				System.out.println(page.getStartCount());
				System.out.println(lastCount);
				
				
			//해당 뷰에서 사용할 속성
			ModelAndView mv = new ModelAndView();
		    mv.addObject("list", list);
		    mv.addObject("totalCount", totalCount);
		    mv.addObject("currentPage", currentPage);
		    mv.addObject("pagingHtml", pagingHtml);
		    mv.addObject("searchType", searchType);
		    mv.addObject("keyword", keyword);
			
			mv.setViewName("/library/listTest.jsp");
			return mv;
		}
}