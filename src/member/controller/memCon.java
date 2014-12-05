package member.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
		
		//절대경로.String FileUploadPath = "/KH_School/WebContent/upload/mem_img/";
		
		//상대경로로 파일을 업로드 하여 통합을 편하게 합니다.
		
		String path = request.getSession().getServletContext().getRealPath("");
		String path2 = "/upload/mem_img/";
		String FileUploadPath = path + path2;
		
		MemberDAO join_dao = MemberDAO.getInstance();
		
		//회원등록 컨트롤러
		
		
		//가입일자 등록
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		//가입년도 등록
		Timestamp a = new Timestamp(System.currentTimeMillis());
		dto.setNum1(a.toString().substring(0, 4));
		
		//num3 회원번호 자동증가 등록
		int num3 = join_dao.plusNum3(dto.getNum2(), dto.getType()) + 1;
		
		
		dto.setNum3(num3);
		
		//통합 번호 id 등록
		if(dto.getNum3() < 10){
			numbering = "00" + dto.getNum3();
		}else if(dto.getNum3() >= 10 && dto.getNum3() < 100){
			numbering = "0" + dto.getNum3();
		}
		
		String id = dto.getNum1() + dto.getNum2() + numbering;
		dto.setId(id);
		
		//주소 검색 후 등록
		
		
		//프로필 사진 파일 업로드 부분
		
		if(!req.getFile("upload").isEmpty()){
			MultipartFile file = req.getFile("upload");
			//파일명에서 확장자 추출.
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().
					length()-3, file.getOriginalFilename().length());
			//ID.확장자 형태로 파일명 만들기.
			String fileName = dto.getId() + "." + extension;
			File saveFile = new File(FileUploadPath + fileName);
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
	
	@RequestMapping(value="/searchAddr.kh")
	public String searchAddr() throws Exception{
		return "/member/addrSearch.jsp";
	}
	
	@RequestMapping(value="/searchAddrPro.kh")
	public ModelAndView searchAddrPro(HttpServletRequest request) throws Exception{
		
		MemberDAO post = MemberDAO.getInstance();
		String sch = request.getParameter("addrSearch");
		
		Map postList = post.getPost(sch);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("postList", postList);
		mv.setViewName("/member/addrSearch.jsp");
		
		return mv;
	}
	
}
