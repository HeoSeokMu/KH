package member.controller;

import java.io.File;
import java.sql.Timestamp;

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

@Controller
public class memCon{
	
	private String FileUploadPath = "D://GeunWoo/Project/git/KH/WebContent/member/mem_img/";
	
	
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
		
		String num2 = request.getParameter("num2");
		String type = request.getParameter("type");
		String numbering = null;
		
		MemberDAO join_dao = MemberDAO.getInstance();
		
		//ȸ����� ��Ʈ�ѷ�
		
		
		//�������� ���
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		//���Գ⵵ ���
		Timestamp a = new Timestamp(System.currentTimeMillis());
		dto.setNum1(a.toString().substring(0, 4));
		
		//num3 ȸ����ȣ �ڵ����� ���
		int num3 = join_dao.plusNum3(num2, type) + 1;
		
		System.out.println("num3 == " + num3);
		System.out.println("num3 == " + num3);
		
		dto.setNum3(num3);
		
		//���� ��ȣ id ���
		if(dto.getNum3() < 10){
			numbering = "00" + dto.getNum3();
		}else if(dto.getNum3() >= 10 && dto.getNum3() < 100){
			numbering = "0" + dto.getNum3();
		}
		
		String id = dto.getNum1() + dto.getNum2() + numbering;
		dto.setId(id);
		
		//������ ���� ���� ���ε� �κ�
		if(req.getFile("upload") != null){
			MultipartFile file = req.getFile("upload");
			String fileName = file.getOriginalFilename();
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
}
