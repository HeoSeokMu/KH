package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;

@Controller
public class CourseGrade {
	@RequestMapping(value="/AttendanceView.kh")
	public String AttendanceView(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("AttendanceView =================== : ");
				
		return "/member/s_AttendanceView.jsp";
	}
	
	@RequestMapping(value="/CourseEvaluation.kh")
	public String CourseEvaluation(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("CourseEvaluation =================== : ");
				
		return "/member/s_CourseEvaluation.jsp";
	}
	
	@RequestMapping(value="/CurrentSemester_gradeView.kh")
	public String CurrentSemester_gradeView(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("CurrentSemester_gradeView =================== : ");
		
		return "/member/s_CurrentSemester_gradeView.jsp";
	}
	
	@RequestMapping(value="/FullSemester_gradeView.kh")
	public String FullSemester_gradeView(HttpSession session, HttpServletRequest req) throws Exception{
		
		System.out.println("FullSemester_gradeView =================== : ");
		
		return "/member/s_FullSemester_gradeView.jsp";
	}
}
