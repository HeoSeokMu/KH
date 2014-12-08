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
public class bookList{//�۸�� ó��

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
			int totalCount; 		// �� �Խù��� ��
			int blockCount = 10;	// �� ��������  �Խù��� ��
			int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
			String pagingHtml; 	//����¡�� ������ HTML
			pagingAction page; 	// ����¡ Ŭ����
			
			// �Խ��� LIST �׼�
				bookDAO dbPro = bookDAO.getInstance();//DB����
				
				// ��� ���� ������ list�� �ִ´�.
				list = dbPro.getArticles(searchType, keyword);
				System.out.println(list.size());
				
				totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
				page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchType, keyword); // pagingAction ��ü ����.
				pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

				// ���� ���������� ������ ������ ���� ��ȣ ����.
				int lastCount = totalCount;

				// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
				if (page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;

				// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
				list = list.subList(page.getStartCount(), lastCount);
				System.out.println(page.getStartCount());
				System.out.println(lastCount);
				
				
			//�ش� �信�� ����� �Ӽ�
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