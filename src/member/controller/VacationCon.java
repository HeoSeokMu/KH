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
	
	//�ް���û �ۼ���
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
	//�ް���û �ۼ�
	@RequestMapping(value="vacationFormPro.kh")
	public ModelAndView vacationFormPro(HttpSession session, HttpServletRequest request, 
			@ModelAttribute vacationDTO vDTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		vDTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea�� �ٹٲ� �±׸� ��ü.
		String content = vDTO.getVacation_reason();
		content = content.replaceAll("\r\n", "<br>");
		vDTO.setVacation_reason(content);
		
		vDTO.setResult("��ó��");
		
		bDAO.insert_vacationBoard(vDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vDTO", vDTO);
		
		mv.setViewName("redirect:/vacationConfirm.kh");
		
		return mv;
	}
	
	//�ް���û �Խ��� ����Ʈ
	@RequestMapping(value="/vacationConfirm.kh")
	public ModelAndView vacationReqList(HttpServletRequest req) throws Exception{
	
		List<vacationDTO> list = new ArrayList<vacationDTO>();
		
		int currentPage = 1;	// ���� ������
		int totalCount;			// �� �Խù��� ��
		int blockCount = 10;	// �� ��������  �Խù��� ��
		int blockPage = 10; 	// �� ȭ�鿡 ������ ������ ��
		vacationReqPagingAction page; 		// ����¡ Ŭ����
		String pagingHtml; 		// ����¡�� ������ HTML	
		
		
		boardDAO bDAO = boardDAO.getInstance();
		list = bDAO.vacationReqList();
		
		String view = "/member/ps_vacationConfirm.jsp";
		
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
		page = new vacationReqPagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			
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
	//�ް���û ó�� Ȯ�� �Խ���
	@RequestMapping(value="/vacationResult.kh")
	public ModelAndView vacationResultList(HttpServletRequest req) throws Exception{
		
		List<vacationDTO> list = new ArrayList<vacationDTO>();
		
		int currentPage = 1;	// ���� ������
		int totalCount;			// �� �Խù��� ��
		int blockCount = 10;	// �� ��������  �Խù��� ��
		int blockPage = 10; 	// �� ȭ�鿡 ������ ������ ��
		vacationResultPagingAction page; 		// ����¡ Ŭ����
		String pagingHtml; 		// ����¡�� ������ HTML
		
		boardDAO bDAO = boardDAO.getInstance();
		list = bDAO.vacationResultList();
		
		String view = "/member/ps_vacationConfirm.jsp";
		
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
		page = new vacationResultPagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			
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
	//�ް� ��û �Խñ� Ȯ��
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
	
	//�ް� ��û ���� ��
		@RequestMapping("/vacationModify.kh")
		public ModelAndView vacationModify(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, 
				@ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			int no = 0;
			no = (Integer.parseInt(request.getParameter("no")));
			String content = request.getParameter("vacation_reason");
			
			//textarea�� �ٹٲ� �±׸� ��ü.
			content = content.replaceAll("<br>", "\r\n");

			ModelAndView mv = new ModelAndView();
			vacationDTO article = bDAO.getVacationArticle(no);
			
			mv.addObject("article", article);
			mv.addObject("vacation_reason", content);
			mv.setViewName("/member/ps_vacationModify.jsp");
			
			return mv;
		}
	//�ް� ��û ����
	@RequestMapping(value="/vacationModifyPro.kh")
	public ModelAndView modifyFormPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
		
		boardDAO bDAO = boardDAO.getInstance();
		
		vDTO.setReg_date(new Timestamp(System.currentTimeMillis()));
		//textarea�� �ٹٲ� �±׸� ��ü.
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
	
	//�ް� ��û �Խñ� ����
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
		
		//�ް� ��û ����
		@RequestMapping(value="/vacationAccept.kh")
		public ModelAndView vacationAccept(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			MemberDAO mDAO = MemberDAO.getInstance();
			
			String id = request.getParameter("id");
			
			String accept = "����";
			vDTO.setResult(accept);
			mDAO.RestCount_Update(id);
			
			bDAO.VacationResultSet(vDTO);
		
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("vDTO", vDTO);
			mv.setViewName("redirect:/vacationResult.kh");
			return mv;
		}
	
		//�ް� ��û ����
		@RequestMapping(value="/vacationDeny.kh")
		public ModelAndView vacationDeny(HttpSession session, HttpServletRequest request, 
				HttpServletResponse response, @ModelAttribute vacationDTO vDTO) throws Exception{
			
			boardDAO bDAO = boardDAO.getInstance();
			
			String deny = "����";
			vDTO.setResult(deny);
			
			bDAO.VacationResultSet(vDTO);
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("vDTO", vDTO);
			mv.setViewName("redirect:/vacationResult.kh");
			return mv;
		}

}
