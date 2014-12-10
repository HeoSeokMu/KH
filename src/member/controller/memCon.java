package member.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dto.memberDTO;
import dto.memberStat_DTO;
import dto.postDTO;

@Controller
public class memCon{
	
	@RequestMapping(value="/joinForm.kh")
	public String form2(){
		return "/member/join_form.jsp";
	}
	
	@RequestMapping("/joinFormPro.kh")
	public ModelAndView formPro(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute memberDTO dto, MultipartHttpServletRequest req) throws Exception{
		
		/*session.setAttribute("memId", dto.getId());
		session.removeAttribute(arg0);
		session.invalidate();*/
		
		String numbering = null;
		
		String [] test = dto.getNum2().split(",");
		dto.setNum2(test[0]);
		dto.setMajor(test[1]);
		
		//������.String FileUploadPath = "/KH_School/WebContent/upload/mem_img/";
		
		//����η� ������ ���ε� �Ͽ� ������ ���ϰ� �մϴ�.
		
		String path = request.getSession().getServletContext().getRealPath("");
		String path2 = "/upload/mem_img/";
		String FileUploadPath = path + path2;
		
		MemberDAO join_dao = MemberDAO.getInstance();
		
		//ȸ����� ��Ʈ�ѷ�
		
		
		//�������� ���
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		//���Գ⵵ ���
		Timestamp a = new Timestamp(System.currentTimeMillis());
		dto.setNum1(a.toString().substring(0, 4));
		
		//num3 ȸ����ȣ �ڵ����� ���
		int num3 = join_dao.plusNum3(dto.getNum2(), dto.getType()) + 1;
		
		
		dto.setNum3(num3);
		
		//���� ��ȣ id ���
		if(dto.getNum3() < 10){
			numbering = "00" + dto.getNum3();
		}else if(dto.getNum3() >= 10 && dto.getNum3() < 100){
			numbering = "0" + dto.getNum3();
		}
		String id = dto.getNum1() + dto.getNum2() + numbering;
		dto.setId(id);
		
		Calendar cal = Calendar.getInstance();
		
		if(dto.getType().equals("�л�")) {
			// �л� ������������
			cal.set(Calendar.YEAR,  cal.get(Calendar.YEAR) + 4);
			cal.set(Calendar.MONTH,  Calendar.FEBRUARY);
			cal.set(Calendar.DATE,  21);
			
			System.out.println("Calendar.YEAR..."+ cal.get(Calendar.YEAR));
			System.out.println("Calendar.MONTH..."+ cal.get(Calendar.MONTH));
			System.out.println("Calendar.DATE..."+ cal.get(Calendar.DATE));
			// ������ �̹����� ���° ������ ����. �Ͽ����� 1, �������� 2..
			System.out.println("Calendar.DAY_OF_WEEK..."+ cal.get(Calendar.DAY_OF_WEEK));
			if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
				cal.add(Calendar.DATE, 1);
			} else if(cal.get(Calendar.DAY_OF_WEEK) == 7){
				cal.add(Calendar.DATE, 2);
			}
			System.out.println("Calendar.DATE..."+ cal.get(Calendar.DATE));
			
			Date end_date = cal.getTime();
			Timestamp end_timestamp = new Timestamp(end_date.getTime());
			
			dto.setEnd_date(end_timestamp);
			dto.setStatus("����");
		} else {
			cal.set(Calendar.YEAR,  9999);
			cal.set(Calendar.MONTH,  12);
			cal.set(Calendar.DATE,  31);
			
			Date end_date = cal.getTime();
			Timestamp end_timestamp = new Timestamp(end_date.getTime());
			
			dto.setEnd_date(end_timestamp);
			
			dto.setStatus("����");
		}
		dto.setGrade(1);
		dto.setSemester(0);
		dto.setRest_count(0);
				
		//�ּ� �˻� �� ���
		
		//������ ���� ���� ���ε� �κ�
		if(!req.getFile("upload").isEmpty()){
			MultipartFile file = req.getFile("upload");
			//���ϸ��� Ȯ���� ����.
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().
					length()-3, file.getOriginalFilename().length());
			//"ID.Ȯ����" ���·� ���ϸ� �����.
			String fileName = dto.getId() + "." + extension;
			File saveFile = new File(FileUploadPath + fileName);
			try{
				file.transferTo(saveFile);
			}catch(Exception e){
				e.printStackTrace();
			}

			dto.setPro_img(fileName);
		}
		
		
		//DB�� insert.
		join_dao.insertMember(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		
		mv.setViewName("/member/test.jsp");
	
		return mv;
	}
	
	@RequestMapping("/myInfo.kh")
	public ModelAndView selectMember(HttpSession session, HttpServletRequest request) throws Exception{
		
		MemberDAO m_dao = MemberDAO.getInstance();
		String id = (String)session.getAttribute("memId");
		memberDTO mDTO = m_dao.member_info(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("mDTO", mDTO);
		
		mv.setViewName("/member/myInfo.jsp");
	
		return mv;
	}
	//�ּҰ˻� �� â ����
	@RequestMapping(value="/searchAddr.kh")
	public String searchAddr() throws Exception{
		return "/member/addrSearch.jsp";
	}
	//�Ķ���� ���� �Ѱ� �޾� �ּ� �˻�.
	@RequestMapping(value="/searchAddrPro.kh")
	public ModelAndView searchAddrPro(@ModelAttribute postDTO Pdto, HttpServletRequest request) throws Exception{
		
		MemberDAO post = MemberDAO.getInstance();
		//�Ķ���� ��ȿ�� �˻� '��'�� ���Ե��� ������ �˻� false.
		String sch = request.getParameter("addrSearch");
		if(sch.contains("��")){
			List list = new ArrayList();
			String cut = sch.substring(0, sch.length()-1);
			
			list = post.getPost(cut);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("postlist", list);
			mv.setViewName("/member/addrSearch.jsp");
			
			return mv;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/addrSearchError.jsp");
		
		return mv;
	}
}
