package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.Action;

import dao.MemberDAO;
import dto.memberDTO;


@Controller
public class Login{
	
	@RequestMapping(value="/LoginPro.kh", method=RequestMethod.POST)
	public ModelAndView Login_check(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("LoginPro =================== : ");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String type = req.getParameter("type");
		int check = 0;
		
		System.out.println(id + " / " + passwd);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		check = mDAO.Login_check(id, passwd, type);
		
		memberDTO mDTO = new memberDTO();
		mDTO = mDAO.member_info(id);
		
		System.out.println("LoginPro check : " + check);
		System.out.println("LoginPro id : " + id);
				
		/*
		session.removeAttribute("memId");			//지정된 세션만 삭제
		session.invalidate();						//모든 세션을 삭제
		*/
		String view = "";
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);						//책번호와 제목을 파라미터로 보네줌
		if(check != 1) {
			mv.addObject("check", check);
			view = "/main/Login_form.jsp";
			System.out.println("check : 0으로 간다!!!");
		} else {
			System.out.println("check : 1로 간다!!!");
			session.setAttribute("memId", id); 	//세션 생성
			session.setAttribute("type", type);
			session.setAttribute("status", mDTO.getStatus());
			view = "/member/notice_board.jsp";
			mv.addObject("check", check);
		}
		
		mv.setViewName(view);
		
		System.out.println("view == " + view);
		System.out.println("memId == " + session.getAttribute("memId"));
		System.out.println("type == " + session.getAttribute("type"));
		System.out.println(mv.getViewName());
		
		return mv;
	}
	
	@RequestMapping(value="/LoginOut.kh", method=RequestMethod.POST)
	public String Logout(HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception{
		
		System.out.println("LoginOut =================== : ");
		
		session.removeAttribute("memId");
		session.removeAttribute("type");
		
		
		return "/main/Login_form.jsp";
	}
}