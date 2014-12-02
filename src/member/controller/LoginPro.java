package member.controller;


import java.nio.channels.SeekableByteChannel;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;

public class LoginPro implements SessionAware{
	private int check;
	private String id;
	private String passwd;
	private Map session;
	
	@RequestMapping("/LoginPro.kh")
	public ModelAndView LoginPro(HttpServletRequest req) throws Exception{
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		System.out.println(id + " / " + passwd);
		
		MemberDAO mDAO = new MemberDAO().getInstance();
		check = mDAO.Login_check(id, passwd);
		
		session.put("memId", id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);						//책번호와 제목을 파라미터로 보네줌
		if(check == 0 || check == 1) {
			mv.setViewName("/member/login_form.jsp");
		} else {
			mv.setViewName("/member/main.jsp");
		}
		
		return mv;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}
}