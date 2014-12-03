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

@Controller
public class Login{
	
	@RequestMapping("/LoginForm.kh")
	public String LoginForm(){
		return "/member/login_form.jsp";
	}
	
	@RequestMapping(value="/LoginPro.kh", method=RequestMethod.POST)
	public ModelAndView Login_check(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("LoginPro =================== : ");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		int check = 0;
		
		System.out.println(id + " / " + passwd);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		check = mDAO.Login_check(id, passwd);
		
		System.out.println("LoginPro check : " + check);
		System.out.println("LoginPro id : " + id);
		
		/*
		session.removeAttribute("memId");			//������ ���Ǹ� ����
		session.invalidate();						//��� ������ ����
		*/
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);						//å��ȣ�� ������ �Ķ���ͷ� ������
		if(check == 0 || check == -1) {
			System.out.println("check : 0���� ����!!!");
		} else {
			System.out.println("check : 1�� ����!!!");
			session.setAttribute("memId", id); 	//���� ����
			mv.addObject("check", check);
		}
		mv.setViewName("/main/main.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/LoginOut.kh", method=RequestMethod.POST)
	public String Logout(HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception{
		
		System.out.println("LoginOut =================== : ");
		
		session.removeAttribute("memId");
		
		return "/main/main.jsp";
	}
}