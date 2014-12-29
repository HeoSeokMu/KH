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

import dao.MemberDAO;
import dao.boardDAO;
import dto.lectureBoardDTO;
import dto.memberDTO;

@Controller
public class lecture_board {
	private static List<lectureBoardDTO> list = new ArrayList<lectureBoardDTO>();
	
	private int currentPage = 1;	// ���� ������
	private int totalCount;			// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 10; 	// �� ȭ�鿡 ������ ������ ��
	private noticePagingAction page; 		// ����¡ Ŭ����
	private String pagingHtml; 		// ����¡�� ������ HTML
	
	@RequestMapping(value="/lectureReq.kh")
	public ModelAndView lectureBoardList(HttpServletRequest req) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		list = bDAO.lecture_BoardList();
		
		String view = "/member/e_lectureReq.jsp";
		if(list == null){
			ModelAndView mv = new ModelAndView();
			mv.addObject("totalCount", 0);
			mv.setViewName(view);
			
			return mv;
		}
		
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		
		String currentPage_check = req.getParameter("currentPage");
		if(currentPage_check == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		page = new noticePagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			
		pagingHtml = page.getPagingHtml().toString();  // ������ HTML ����.
	
		//paging
		int lastCount = totalCount;
			
		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("totalCount", totalCount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("pagingHtml", pagingHtml);
		mv.addObject("blockCount", blockCount);
		mv.setViewName(view);
		
		return mv;
	}
	
	@RequestMapping(value="/writeLectureReq.kh")
	public ModelAndView writeform(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/member/content.jsp");
		
		return mv;
	}
	
	@RequestMapping("/writeLectureReqPro.kh")
	public ModelAndView writeformPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute lectureBoardDTO l_DTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		l_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea�� �ٹٲ� �±׸� ��ü.
		String content = l_DTO.getContent();
		content = content.replaceAll("\r\n", "<br>");
		l_DTO.setContent(content);
		
		bDAO.insert_lectureBoard(l_DTO);;
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nb_DTO", l_DTO);
		
		mv.setViewName("redirect:/notice_board.kh");
		
		return mv;
	}
	
	@RequestMapping("/lectureReqView.kh")
	public ModelAndView contentView(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute lectureBoardDTO nb_DTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		int no = 0;
		no = (Integer.parseInt(request.getParameter("no")));
		
		
		
		ModelAndView mv = new ModelAndView();
		lectureBoardDTO article = bDAO.getArticle(no);

		
		mv.addObject("article", article);
		
		mv.setViewName("/member/content.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/modifyLectureReq.kh")
	public ModelAndView modifyForm(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, @ModelAttribute memberDTO mDTO) throws Exception{
		
		String name;
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//textarea�� �ٹٲ� �±׸� ��ü.
		content = content.replaceAll("<br>", "\r\n");

		String id = (String) session.getAttribute("memId");
		boardDAO bDAO = boardDAO.getInstance();
		MemberDAO mDAO = MemberDAO.getInstance();
		
		mDTO = mDAO.member_info(id);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mDTO", mDTO);
		mv.addObject("title", title);
		mv.addObject("content", content);
		mv.addObject("num", num);
		mv.setViewName("/member/content.jsp");
		return mv;
	}
	
	@RequestMapping(value="/modifyLectureReqPro.kh")
	public ModelAndView modifyFormPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, @ModelAttribute lectureBoardDTO l_DTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		l_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea�� �ٹٲ� �±׸� ��ü.
		String content = request.getParameter("content");
		content = content.replaceAll("\r\n", "<br>");
		l_DTO.setContent(content);
		
		bDAO.modifyArticle(l_DTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("l_DTO", l_DTO);
		mv.setViewName("redirect:/notice_board.kh");
		return mv;
	}
	
	@RequestMapping("/deleteLectureReq.kh")
	public ModelAndView deleteNotice_board(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute lectureBoardDTO l_DTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		int no = (Integer.parseInt(request.getParameter("no")));

		System.out.println(no);
		ModelAndView mv = new ModelAndView();
		lectureBoardDTO article = bDAO.deleteArticle(no);
		
		mv.addObject("article", article);
		
		mv.setViewName("redirect:/notice_board.kh");
		
		return mv;
	}
	
}