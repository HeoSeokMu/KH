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
public class bookList{//�۸�� ó��

		@RequestMapping(value="/bookList.kh", method=RequestMethod.POST)
		public ModelAndView formPro(HttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
			
		@RequestMapping(value="/bookList.kh", method=RequestMethod.GET)
		public ModelAndView formPro(HttpServletRequest req) throws Exception{
			String searchType = req.getParameter("searchType");
			String word = req.getParameter("word");
			System.out.println(word);
			System.out.println(searchType);
			String pageNum = req.getParameter("pageNum");//������ ��ȣ
			if (pageNum == null) {
		            pageNum = "1";
		    }
			
			int pageSize = 20;//�� �������� ���� ����
			int pageSize = 10;//�� �������� ���� ����
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
	        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
	        int startRow = (currentPage - 1) * pageSize;//�� �������� ���۱� ��ȣ
	        int endRow = currentPage * pageSize - 1;//�� �������� ������ �۹�ȣ
	        int count = 0;
	        int number=0;
	        
	        List articleList = null;
	        List<libraryDTO> articleList = null;
	        bookDAO dbPro = bookDAO.getInstance();//DB����
	        //count = dbPro.getArticleCount();//��ü ���� ��
	        
	        
	        if (count > 0) {
	            articleList = dbPro.getArticles(startRow, endRow);//���� �������� �ش��ϴ� �� ���													
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
		        		articleList = dbPro.getSelectAll(startRow, endRow, word);//���� �������� �ش��ϴ� �� ��ü�˻����
		        		System.out.println("getSelectAll ����");
	        		}else if(searchType.equals("title")){
		        		articleList = dbPro.getSelectAll(startRow, endRow, word);//���� �������� �ش��ϴ� �� ����˻����
		        		System.out.println("getSelectAll ����");
		        	}else{
		        		articleList = dbPro.getSelectWriter(startRow, endRow, word);//���� �������� �ش��ϴ� �� ���ڰ˻����
		        		System.out.println("getSelectWriter ����");
		        	}
		        }else {
    	            articleList = Collections.EMPTY_LIST;
    	            System.out.println("Collections.EMPTY_LIST ����");
    	            
    	        }
	        }else{
        		count = dbPro.getArticleCount();//��ü ���� ��
        		if(count >0){
        			articleList = dbPro.getArticles(startRow, endRow);//���� �������� �ش��ϴ� �� ���
        			System.out.println("getArticles ����");
        		}else {
    	            articleList = Collections.EMPTY_LIST;
    	            System.out.println("Collections.EMPTY_LIST ����");
    	        }
        	}
			number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
			
			System.out.println(count);
			System.out.println(articleList);
			//�ش� �信�� ����� �Ӽ�
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