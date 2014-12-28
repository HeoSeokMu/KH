package member.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.RestReturnBoard_DTO;
import dto.memberDTO;
import dto.noticeboard_DTO;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RestReturn_board {
	
	private static List<RestReturnBoard_DTO> list = new ArrayList<RestReturnBoard_DTO>();
	
	private int currentPage = 1;	// ���� ������
	private int totalCount;			// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 10; 	// �� ȭ�鿡 ������ ������ ��
	private noticePagingAction page; 		// ����¡ Ŭ����
	private String pagingHtml; 		// ����¡�� ������ HTML
	
	@RequestMapping(value="/RestReturnRequest_board.kh")
	public ModelAndView notice_board(HttpServletRequest req) throws Exception{
		
		System.out.println("RestReturnRequest_board =================== : ");
		String board_type = req.getParameter("board_type");
		MemberDAO mDAO = MemberDAO.getInstance();
		list = mDAO.RestReturn_BoardList(board_type);
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		
		System.out.println("totalCount : " + totalCount);
		
		String currentPage_check = req.getParameter("currentPage");
		if(currentPage_check == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		page = new noticePagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			
		pagingHtml = page.getPagingHtml().toString();  // ������ HTML ����.
		System.out.println("pagingHtml : " + pagingHtml);
		
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
		mv.setViewName("/member/e_RestReturnRequest_board.jsp");
		
		System.out.println(mv.getViewName());
		
		return mv;
	}
	
	@RequestMapping(value="/returnSchool.kh")
	public ModelAndView returnSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("returnSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO mDTO = new memberDTO(); 
		mDTO = mDAO.student_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);
		mv.setViewName("/member/s_returnSchool.jsp");
	
		return mv;
	}
	
	@RequestMapping(value="/restSchool.kh")
	public ModelAndView restSchool(HttpServletRequest req) throws Exception{
		
		System.out.println("restSchool =================== : ");
		
		String id = req.getParameter("id");
		
		System.out.println(id);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		memberDTO mDTO = new memberDTO(); 
		mDTO = mDAO.student_info(id);
		
		System.out.println(mDTO.getAddr());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);						
		mv.setViewName("/member/s_restSchool.jsp");
	
		return mv;
	}
	
	@RequestMapping(value="/RestReturnRequestInsert.kh")
	public ModelAndView restInsert(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("RestReturnRequestInsert.kh =================== : ");
		RestReturnBoard_DTO rrb_DTO = new RestReturnBoard_DTO();
		
		String board_type = req.getParameter("board_type");
		String id = req.getParameter("id");
		
		rrb_DTO.setMajor(req.getParameter("major"));
		rrb_DTO.setAddr(req.getParameter("addr"));
		rrb_DTO.setEmail(req.getParameter("email"));
		int grade = Integer.parseInt(req.getParameter("grade"));
		rrb_DTO.setGrade(grade);
		rrb_DTO.setId(id);
		rrb_DTO.setName(req.getParameter("name"));
		rrb_DTO.setPhone(req.getParameter("phone"));
		rrb_DTO.setTime(req.getParameter("time"));
		rrb_DTO.setWhy(req.getParameter("why"));
		rrb_DTO.setWhy_detail(req.getParameter("why_detail"));
		rrb_DTO.setResult("��ó��");
		rrb_DTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		rrb_DTO.setBoard_type(board_type);
		
		System.out.println("rrb_DTO.getReg = "+rrb_DTO.getReg_date());
		System.out.println("rrb_DTO.getPhone = "+rrb_DTO.getPhone());
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		mDAO.insertRestReturnBoard(rrb_DTO);
		String status = "";
		if(board_type.equals("����")){
			status = "���н�û��";
		} else if(board_type.equals("����")) {
			status = "���н�û��";
		}
		mDAO.modify_MerberRest(status, id);
		
		session.removeAttribute("status");
		session.setAttribute("status", status);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", rrb_DTO);						
		mv.setViewName("redirect:/notice_board.kh");
	
		return mv;
	}
	
	@RequestMapping(value="/RestReturn_Board.kh")
	public ModelAndView RestReturn_Board(HttpServletRequest req) throws Exception{
		
		System.out.println("RestReturn_Board =================== : ");
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String rrrb_check = req.getParameter("rrrb_check");
		String board_type = req.getParameter("board_type");
		System.out.println("rrrb_check : "+rrrb_check);
		System.out.println("board_type : "+board_type);
		
		String view = "";
		String status = "";
		if(rrrb_check.equals("��û")) {
			list = mDAO.RestReturn_BoardList(board_type);
			view = "/member/e_RestReturnRequest_board.jsp";
		} else if(rrrb_check.equals("ó��")) {
			list = mDAO.RestReturn_Board_Processing_List(board_type);
			view = "/member/e_RestReturnProcessing_board.jsp";
		}
		
		System.out.println("view : " + view);
		
		if(list == null){
			System.out.println("list null?");
			ModelAndView mv = new ModelAndView();
			mv.addObject("totalCount", 0);
			mv.addObject("board_type", board_type);
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
		mv.addObject("rrrb_check", rrrb_check);
		mv.addObject("board_type", board_type);
		mv.setViewName(view);
		
		return mv;
	}
	
	@RequestMapping(value="/RestReturn_Pro.kh")
	public ModelAndView RestReturn_Pro(HttpSession session, HttpServletRequest req) throws Exception{
		System.out.println("RestReturn_Pro =================== : ");
		
		String id = req.getParameter("id");
		String result = req.getParameter("result");
		int num = Integer.parseInt(req.getParameter("num"));
		int rest_count = Integer.parseInt(req.getParameter("rest_count"));
		String board_type = req.getParameter("board_type");
		String why = req.getParameter("why");
		
		System.out.println("id : " + id);
		System.out.println("result : " + result);
		System.out.println("num : " + num);
		System.out.println("board_type : " + board_type);
		
		MemberDAO mDAO = MemberDAO.getInstance();
				
		String status = "";
		String view = "";
		if(board_type.equals("����")) {
			if(result.equals("����")) {
				status = "����";
			} else if(result.equals("����")) {
				status = "����";
			}
		} else if(board_type.equals("����")) {
			if(result.equals("����")) {
				status = "����";
			} else if(result.equals("����")) {
				status = "����";
			}
		}
		mDAO.modify_RestReturnBoard(result, num, board_type);
		mDAO.modify_MerberRest(status, id);
		mDAO.RestCount_Update(id);
		rest_count = mDAO.RestCount(id);
		
		session.removeAttribute("status");
		session.removeAttribute("rest_count");
		session.setAttribute("status", status);
		System.out.println("rest_count : " + rest_count);
		session.setAttribute("rest_count", rest_count);
		
		// ���� �������� ��������
		memberDTO mDTO = mDAO.member_info(id);
		Timestamp end_date = mDTO.getEnd_date();
		System.out.println("why : " + why);
		System.out.println("end_date : " + end_date);
		
		// ���� �������� �����ϱ�
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(end_date.getTime());
		if(why.equals("���Դ�")) {
			cal.set(Calendar.YEAR,  cal.get(Calendar.YEAR) + 2);
		} else if(why.equals("�� ��") || why.equals("�� Ÿ")) {
			cal.set(Calendar.MONTH,  cal.get(Calendar.MONTH) + 6);
		} else if(why.equals("�� ��")) {
			cal.set(Calendar.YEAR,  cal.get(Calendar.YEAR) + 1);
		}
		
		// ������ �̹����� ���° ������ ����. �Ͽ����� 1, �������� 2..
		if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
			cal.add(Calendar.DATE, 1);
		} else if(cal.get(Calendar.DAY_OF_WEEK) == 7){
			cal.add(Calendar.DATE, 2);
		}
		
		Date endDate_Cal = cal.getTime();
		Timestamp endDate_Plus = new Timestamp(endDate_Cal.getTime());
		
		mDAO.EndDate_Update(endDate_Plus, id);
		
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("redirect:/RestReturn_Board.kh?board_type="+board_type+"&rrrb_check=ó��");
		mv.setViewName("redirect:/notice_board.kh");
		return mv;
	}
	
	@RequestMapping("/RestContent.kh")
	public ModelAndView RestContentView(HttpServletRequest request) throws Exception{
		MemberDAO mDAO = MemberDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		String rrrb_check = request.getParameter("rrrb_check");
		
		ModelAndView mv = new ModelAndView();
		RestReturnBoard_DTO rrb_DTO = mDAO.Rest_Content(num);

		mv.addObject("rrb_DTO", rrb_DTO);
		mv.addObject("rrrb_check", rrrb_check);
		
		mv.setViewName("/member/e_Rest_Content.jsp");
		
		return mv;
	}
}