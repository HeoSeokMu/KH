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
import dto.memberDTO;
import dto.vacationDTO;

@Controller
public class VacationCon {
	
	//휴가신청 작성폼
	@RequestMapping(value="vacationForm.kh")
	public ModelAndView vacationForm(HttpSession session, HttpServletRequest request, 
			@ModelAttribute memberDTO dto) throws Exception{
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = (String)session.getAttribute("memId");
		memberDTO mDTO = mDAO.member_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);
		
		mv.setViewName("/member/ps_vacationForm.jsp");
		
		return mv;
	}
	//휴가신청 작성
	@RequestMapping(value="vacationFormPro.kh")
	public ModelAndView vacationFormPro(HttpSession session, HttpServletRequest request, 
			@ModelAttribute vacationDTO vDTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		vDTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea의 줄바꿈 태그를 교체.
		String content = vDTO.getVacation_reason();
		content = content.replaceAll("\r\n", "<br>");
		vDTO.setVacation_reason(content);
		
		vDTO.setResult("미처리");
		
		bDAO.insert_vacationBoard(vDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vDTO", vDTO);
		
		mv.setViewName("redirect:/vacationConfirm.kh");
		
		return mv;
	}
	
	//휴가신청 게시판 리스트
	@RequestMapping(value="/vacationConfirm.kh")
	public ModelAndView vacationReqList(HttpServletRequest req) throws Exception{
	
		List<vacationDTO> list = new ArrayList<vacationDTO>();
		
		int currentPage = 1;	// 현재 페이지
		int totalCount;			// 총 게시물의 수
		int blockCount = 10;	// 한 페이지의  게시물의 수
		int blockPage = 10; 	// 한 화면에 보여줄 페이지 수
		vacationReqPagingAction page; 		// 페이징 클래스
		String pagingHtml; 		// 페이징을 구현한 HTML	
		
		
		boardDAO bDAO = boardDAO.getInstance();
		list = bDAO.vacationReqList();
		
		String view = "/member/ps_vacationConfirm.jsp";
		
		if(list == null){
			ModelAndView mv = new ModelAndView();
			mv.addObject("totalCount", 0);
			mv.setViewName(view);
			
			return mv;
		}
		
		totalCount = list.size(); // 전체 글 갯수를 구한다.
		
		String currentPage_check = req.getParameter("currentPage");
		if(currentPage_check == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		page = new vacationReqPagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
			
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
		mv.setViewName(view);
		
		return mv;
	}
	//휴가신청 처리 확인 게시판
	@RequestMapping(value="/vacationResult.kh")
	public ModelAndView vacationResultList(HttpServletRequest req) throws Exception{
		
		List<vacationDTO> list = new ArrayList<vacationDTO>();
		
		int currentPage = 1;	// 현재 페이지
		int totalCount;			// 총 게시물의 수
		int blockCount = 10;	// 한 페이지의  게시물의 수
		int blockPage = 10; 	// 한 화면에 보여줄 페이지 수
		vacationResultPagingAction page; 		// 페이징 클래스
		String pagingHtml; 		// 페이징을 구현한 HTML
		
		boardDAO bDAO = boardDAO.getInstance();
		list = bDAO.vacationResultList();
		
		String view = "/member/ps_vacationConfirm.jsp";
		
		if(list == null){
			ModelAndView mv = new ModelAndView();
			mv.addObject("totalCount", 0);
			mv.setViewName(view);
			
			return mv;
		}
		
		totalCount = list.size(); // 전체 글 갯수를 구한다.
		
		String currentPage_check = req.getParameter("currentPage");
		if(currentPage_check == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		page = new vacationResultPagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
			
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
		mv.setViewName(view);
		
		return mv;
	}
	//휴가 신청 게시글 확인
	@RequestMapping("/vacationView.kh")
	public ModelAndView vacationView(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute vacationDTO vDTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		int no = 0;
		no = (Integer.parseInt(request.getParameter("no")));

		ModelAndView mv = new ModelAndView();
		vacationDTO article = bDAO.getVacationArticle(no);
		
		mv.addObject("article", article);
		mv.setViewName("/member/ps_vacationView.jsp");
		
		return mv;
	}
	
	//휴가 신청 수정 폼
		@RequestMapping("/vacationModify.kh")
		public ModelAndView vacationModify(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, 
				@ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			int no = 0;
			no = (Integer.parseInt(request.getParameter("no")));
			String content = request.getParameter("vacation_reason");
			
			//textarea의 줄바꿈 태그를 교체.
			content = content.replaceAll("<br>", "\r\n");

			ModelAndView mv = new ModelAndView();
			vacationDTO article = bDAO.getVacationArticle(no);
			
			mv.addObject("article", article);
			mv.addObject("vacation_reason", content);
			mv.setViewName("/member/ps_vacationModify.jsp");
			
			return mv;
		}
	//휴가 신청 수정
	@RequestMapping(value="/vacationModifyPro.kh")
	public ModelAndView modifyFormPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		vDTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea의 줄바꿈 태그를 교체.
		String content = request.getParameter("vacation_reason");
		content = content.replaceAll("\r\n", "<br>");
		vDTO.setVacation_reason(content);
			
		if(request.getParameter("changeCheck") == null){
			vDTO.setVacStart_yy(request.getParameter("origin_syy"));
			vDTO.setVacStart_mm(request.getParameter("origin_smm"));
			vDTO.setVacStart_dd(request.getParameter("origin_sdd"));
			
			vDTO.setVacEnd_yy(request.getParameter("origin_eyy"));
			vDTO.setVacEnd_mm(request.getParameter("origin_emm"));
			vDTO.setVacEnd_dd(request.getParameter("origin_edd"));
		}
		
		bDAO.modifyVacation(vDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("vDTO", vDTO);
		mv.setViewName("redirect:/vacationConfirm.kh");
		return mv;
	}
	
	//휴가 신청 게시글 삭제
		@RequestMapping("/vacationDelete.kh")
		public ModelAndView vacationDel(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, 
				@ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			int no = 0;
			no = (Integer.parseInt(request.getParameter("no")));

			ModelAndView mv = new ModelAndView();
			vacationDTO article = bDAO.deleteVacation(no);
			
			mv.addObject("article", article);
			mv.setViewName("redirect:/vacationConfirm.kh");
			
			return mv;
		}
		
		//휴가 신청 승인
		@RequestMapping(value="/vacationAccept.kh")
		public ModelAndView vacationAccept(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			MemberDAO mDAO = MemberDAO.getInstance();
			
			String id = request.getParameter("id");
			
			String accept = "승인";
			vDTO.setResult(accept);
			mDAO.RestCount_Update(id);
			
			bDAO.VacationResultSet(vDTO);
		
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("vDTO", vDTO);
			mv.setViewName("redirect:/vacationResult.kh");
			return mv;
		}
	
		//휴가 신청 거절
		@RequestMapping(value="/vacationDeny.kh")
		public ModelAndView vacationDeny(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			
			String deny = "거절";
			vDTO.setResult(deny);
			
			bDAO.VacationResultSet(vDTO);
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("vDTO", vDTO);
			mv.setViewName("redirect:/vacationResult.kh");
			return mv;
		}

}
