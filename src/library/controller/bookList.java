package library.controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookInsertDAO;
import dao.rentDAO;
import dto.rentDTO;

@Controller	
public class bookList{//�۸�� ó��

		@RequestMapping(value="/inputNumPro.kh", method=RequestMethod.POST)
		public ModelAndView formPro(HttpServletRequest req, @ModelAttribute rentDTO dto) throws Exception{
			
			String pageNum = req.getParameter("pageNum");//������ ��ȣ
			if (pageNum == null) {
		            pageNum = "1";
		    }
			
			int pageSize = 20;//�� �������� ���� ����
	        int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
	        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
	        int count = 0;
	        int number=0;
	        
	        List articleList = null;
	        bookInsertDAO dbPro = bookInsertDAO.getInstance();//DB����
	        //count = dbPro.getArticleCount();//��ü ���� ��
	        
	        
	        if (count > 0) {
	            articleList = dbPro.getArticles(startRow, endRow);//���� �������� �ش��ϴ� �� ���													
	        } else {
	            articleList = Collections.EMPTY_LIST;
	        }
			number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
			
			//�ش� �信�� ����� �Ӽ�
			ModelAndView mv = new ModelAndView();
			mv.addObject("articleList", articleList);
			mv.addObject("currentPage", new Integer(currentPage));
			mv.addObject("startRow", new Integer(startRow));
			mv.addObject("endRow", new Integer(endRow));
			mv.addObject("count", new Integer(count));
			mv.addObject("pageSize", new Integer(pageSize));
			mv.addObject("number", new Integer(number));
			
			mv.setViewName("/library/.jsp");
			return mv;
		}
}