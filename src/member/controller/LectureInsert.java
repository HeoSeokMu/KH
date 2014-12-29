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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.sugangDAO;
import dto.memberDTO;
import dto.postDTO;
import dto.sugangDTO;

@Controller
public class LectureInsert{
	
	@RequestMapping(value="/lectureInsertForm.kh")
	public ModelAndView lectureInsertForm(HttpServletRequest request) throws Exception{
		System.out.println("lectureInsertForm =======================");
		
		MemberDAO m_DAO = MemberDAO.getInstance();
		
		String id = request.getParameter("p_code");
		System.out.println("id : " + id);
		memberDTO mDTO = m_DAO.member_info(id);
		System.out.println("name : " + mDTO.getName());
		String name = mDTO.getName();
		String major = mDTO.getMajor();

		
		sugangDAO lecture_DAO = sugangDAO.getInstance();
		List l_code = new ArrayList<String>();
		l_code = lecture_DAO.selectL_Code();
	
		for(int i = 0; i<l_code.size(); i++) {
			System.out.println("l_room : " + l_code.get(i).toString());
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("p_code", id);
		mv.addObject("l_code", l_code);
		mv.addObject("name", name);
		mv.addObject("major", major);
		mv.setViewName("/member/p_LectureInsert.jsp");
		
		return mv;
	}
	
	@RequestMapping("/lectureInsertPro.kh")
	public ModelAndView lectureInsertPro(HttpServletRequest request, @ModelAttribute sugangDTO s_DTO) throws Exception{
		
		sugangDAO lecture_DAO = sugangDAO.getInstance();
		
		int f_grade = Integer.parseInt(request.getParameter("f_grade1"));
		int l_start = Integer.parseInt(request.getParameter("l_start1"));
		int l_end = Integer.parseInt(request.getParameter("l_end1"));
		int limit_stu = Integer.parseInt(request.getParameter("limit_stu1"));
		int semester = Integer.parseInt(request.getParameter("semester1"));
		int y_grade = Integer.parseInt(request.getParameter("y_grade1"));
		
		s_DTO.setF_grade(f_grade);
		s_DTO.setL_start(l_start);
		s_DTO.setL_end(l_end);
		s_DTO.setLimit_stu(limit_stu);
		s_DTO.setSemester(semester);
		s_DTO.setY_grade(y_grade);
		
		s_DTO.setIn_stu(0);
		s_DTO.setS_date("2014-03-02");
		s_DTO.setL_date("2014-06-20");
		
		lecture_DAO.insertSugang(s_DTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/notice_board.kh");
		
		return mv;
	}
}
