package member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.noticeboard_DTO;

@Controller
public class notice_board {
	private static List<noticeboard_DTO> list = new ArrayList<noticeboard_DTO>();
	
	private int currentPage = 1;	// ���� ������
	private int totalCount;			// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 		// �� ȭ�鿡 ������ ������ ��
	private pagingAction page; 		// ����¡ Ŭ����
	private String pagingHtml; 		// ����¡�� ������ HTML
	private String type;			// �帣
	
	@RequestMapping(value="/notice_board.kh", method=RequestMethod.POST)
	public ModelAndView notice_board(HttpServletRequest req) throws Exception{
		
		System.out.println("notice_board =================== : ");
		
		list = sqlMapper.queryForList("musicSQL.genreSelectAll", type);
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
				
		setCurrentPage(currentPage);
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage, category); // pagingAction ��ü ����.
			
		System.out.println("list f : " + list);
		setPagingHtml(page.getPagingHtml().toString());  // ������ HTML ����.
		//paging
			
		int lastCount = totalCount;
			
		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);						//å��ȣ�� ������ �Ķ���ͷ� ������
		mv.setViewName("/member/notice_board.jsp");
		
		System.out.println(mv.getViewName());
		
		return mv;
	}
}