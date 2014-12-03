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
	
	private String FileUploadPath = "D://GeunWoo/Project/git/KH/member/mem_img";
	
	
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
		
		MemberDAO join_dao = MemberDAO.getInstance();
		
		//회원등록 컨트롤러
		
		
		//가입일자 등록
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		Timestamp a = new Timestamp(System.currentTimeMillis());
		dto.setNum1(a.toString().substring(0, 4));
		
		
		
		//프로필 사진 파일 업로드 부분
		if(req.getFile("upload") != null){
			MultipartFile file = req.getFile("upload");
			String fileName = file.getOriginalFilename();
			File saveFile = new File(FileUploadPath+fileName);
			try{
				file.transferTo(saveFile);
			}catch(Exception e){
				e.printStackTrace();
			}

			dto.setPro_img(fileName);
			}
		
		//DB에 insert.

		join_dao.insertMember(dto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		
		mv.setViewName("/member/test.jsp");
	
		return mv;
		
	}
}
