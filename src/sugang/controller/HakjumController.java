package sugang.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.hakjumDAO;
import dao.sugangDAO;
import dto.hakjumDTO;
import dto.memberDTO;
import dto.sugangDTO;

@Controller
public class HakjumController {

	@RequestMapping(value="/hakjumForm.kh")
	public ModelAndView hakjumForm(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
/*		String code = (String) session.getAttribute("memId");
		int p_code = Integer.parseInt(code);*/
		int p_code = 2014401001; // 교수 코드
		
		List<sugangDTO> suganglist = new ArrayList<sugangDTO>();
		sugangDTO sugangdto = new sugangDTO();
		
		List<hakjumDTO> list = new ArrayList<hakjumDTO>();
		hakjumDTO dto = new hakjumDTO();
		hakjumDAO dao = hakjumDAO.getInstance();
		
		sugangDAO sugangdao = sugangDAO.getInstance();
		suganglist = sugangdao.getList(p_code);
		
		MemberDAO memdao = MemberDAO.getInstance();
		memberDTO memdto = new memberDTO();
		memdto = memdao.member_info(Integer.toString(p_code));
		
		
		list = dao.getList(p_code);
		for(hakjumDTO hakjum : list){
			String type = dto.getType();
			if(type == "e"){
				hakjum.setType("전 필");
			}else{
				hakjum.setType("전 선");
			}
		}
		
		mv.addObject("memdto",memdto);
		mv.addObject("suganglist",suganglist);	
		mv.addObject("list",list);
		mv.setViewName("hakjum/hakjum.jsp");
		return mv;
	}
	
	@RequestMapping(value="/hakjumPro.kh")
	public ModelAndView hakjumForm(HttpServletRequest req) throws SQLException{
		
/*		String code = (String) session.getAttribute("memId");
		int p_code = Integer.parseInt(code);*/
		int p_code = 2014401001; // 교수 코드
		
		
		String code = req.getParameter("code");
		List<hakjumDTO> list = new ArrayList<hakjumDTO>();
		
		List<sugangDTO> suganglist = new ArrayList<sugangDTO>();
		sugangDTO sugangdto = new sugangDTO();
		
		hakjumDTO dto = new hakjumDTO();
		hakjumDAO dao = hakjumDAO.getInstance();
		
		sugangDAO sugangdao = sugangDAO.getInstance();
		
		suganglist = sugangdao.getList(p_code);
		list = dao.getList(code);
		
		for(hakjumDTO hakjum : list){
			String type = dto.getType();
			if(type == "e"){
				hakjum.setType("전 필");
			}else{
				hakjum.setType("전 선");
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("suganglist",suganglist);	
		mv.addObject("list",list);	
		mv.setViewName("hakjum/hakjumPro.jsp");
		return mv;
	}
	
	@RequestMapping(value="/hakjumInsert.kh")
	public ModelAndView hakjumInsert(HttpServletRequest req) throws Exception{

		hakjumDAO dao = hakjumDAO.getInstance();
		
/*		String code = (String) session.getAttribute("memId");
		int p_code = Integer.parseInt(code);
	*/
		int p_code = 2014401001; // 교수 코드
		
		String num[] = req.getParameterValues("num");
		int result = 0;
		for(int i=0; i < num.length; i++){
			String A = req.getParameter("A"+num[i]);
			int resultA = Integer.parseInt(A);
			
			String B = req.getParameter("B"+num[i]);
			
			result = result + dao.insert(Integer.parseInt(num[i]),resultA,B);
		}
		
		ModelAndView mv = new ModelAndView();
		
		if(result == num.length){
			mv.setViewName("hakjum/hakjumOK.jsp");
		}else{
			mv.setViewName("hakjum/hakjumError.jsp");
		}
		return mv;
	}
}

