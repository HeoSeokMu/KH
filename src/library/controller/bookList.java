package library.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;
import dto.rentDTO;
import dao.bookDAO;
import dto.libraryDTO;

@Controller	
public class bookList{//글목록 처리

		@RequestMapping(value="/bookList.kh", method=RequestMethod.POST)
		public ModelAndView formPro(HttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
			
		@RequestMapping(value="/bookList.kh", method=RequestMethod.GET)
		public ModelAndView formPro(HttpServletRequest req) throws Exception{
			String searchType = req.getParameter("searchType");
			String word = req.getParameter("word");
			System.out.println(word);
			System.out.println(searchType);
			String pageNum = req.getParameter("pageNum");//페이지 번호
			if (pageNum == null) {
		            pageNum = "1";
		    }
			
			int pageSize = 20;//한 페이지의 글의 개수
			int pageSize = 10;//한 페이지의 글의 개수
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	        int startRow = (currentPage - 1) * pageSize;//한 페이지의 시작글 번호
	        int endRow = currentPage * pageSize - 1;//한 페이지의 마지막 글번호
	        int count = 0;
	        int number=0;
	        
	        List articleList = null;
	        List<libraryDTO> articleList = null;
	        bookDAO dbPro = bookDAO.getInstance();//DB연동
	        //count = dbPro.getArticleCount();//전체 글의 수
	        
	        
	        if (count > 0) {
	            articleList = dbPro.getArticles(startRow, endRow);//현재 페이지에 해당하는 글 목록													
	        } else {
	            articleList = Collections.EMPTY_LIST;
	        }
	        if(searchType!=null){
		        if(searchType.equals("all")){
		        	count = dbPro.getSelectAllCount(word);
	    		}else if(searchType.equals("title")){
	    			count = dbPro.getSelectTitleCount(word);
	        	}else{
	        		count = dbPro.getSelectWriterCount(word);
	        	}
		        if (count > 0) { 
	        		if(searchType.equals("all")){
		        		articleList = dbPro.getSelectAll(startRow, endRow, word);//현재 페이지에 해당하는 글 전체검색결과
		        		System.out.println("getSelectAll 실행");
	        		}else if(searchType.equals("title")){
		        		articleList = dbPro.getSelectAll(startRow, endRow, word);//현재 페이지에 해당하는 글 서명검색결과
		        		System.out.println("getSelectAll 실행");
		        	}else{
		        		articleList = dbPro.getSelectWriter(startRow, endRow, word);//현재 페이지에 해당하는 글 저자검색결과
		        		System.out.println("getSelectWriter 실행");
		        	}
		        }else {
    	            articleList = Collections.EMPTY_LIST;
    	            System.out.println("Collections.EMPTY_LIST 실행");
    	            
    	        }
	        }else{
        		count = dbPro.getArticleCount();//전체 글의 수
        		if(count >0){
        			articleList = dbPro.getArticles(startRow, endRow);//현재 페이지에 해당하는 글 목록
        			System.out.println("getArticles 실행");
        		}else {
    	            articleList = Collections.EMPTY_LIST;
    	            System.out.println("Collections.EMPTY_LIST 실행");
    	        }
        	}
			number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
			
			System.out.println(count);
			System.out.println(articleList);
			//해당 뷰에서 사용할 속성
			ModelAndView mv = new ModelAndView();
			mv.addObject("articleList", articleList);
			mv.addObject("currentPage", new Integer(currentPage));
			mv.addObject("startRow", new Integer(startRow));
			mv.addObject("endRow", new Integer(endRow));
			mv.addObject("count", new Integer(count));
			mv.addObject("pageSize", new Integer(pageSize));
			mv.addObject("number", new Integer(number));
			mv.addObject("searchType", searchType);
			mv.addObject("word", word);
			
			mv.setViewName("/library/bookList.jsp");
			return mv;
		}
}