package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.lectureBoardDTO;
import dto.vacationDTO;

public class boardDAO {

	private static boardDAO instance = new boardDAO();

	public static boardDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
		return ds.getConnection();
	}
	
	// 강의개설신청
	public void insert_lectureBoard(lectureBoardDTO l_DTO) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"insert into KH_lectureboard values (kh_lectureboard_seq.NEXTVAL,?,?,?,?,?)");
            pstmt.setString(1, l_DTO.getL_name());
            pstmt.setString(2, l_DTO.getProfessor());
            pstmt.setString(3, l_DTO.getContent());
            pstmt.setTimestamp(4, l_DTO.getReg_date());
            pstmt.setString(5, l_DTO.getResult());
            
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        
    }
	
	// 개설 신청 강의 리스트
	public List<lectureBoardDTO> lecture_BoardList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<lectureBoardDTO> lectureBoard_List = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from KH_lectureboard order by no desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				lectureBoard_List = new ArrayList<lectureBoardDTO>();
				do {
					lectureBoardDTO l_dto = new lectureBoardDTO();
					l_dto.setNo(rs.getInt("no"));
					l_dto.setL_name(rs.getString("l_name"));
					l_dto.setProfessor(rs.getString("professor"));
					l_dto.setContent(rs.getString("content"));
					l_dto.setReg_date(rs.getTimestamp("reg_date"));
					l_dto.setResult(rs.getString("result"));
					lectureBoard_List.add(l_dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		return lectureBoard_List;
	}

	//시퀀스 넘버로 게시글을 가져오는 쿼리.
	public lectureBoardDTO getArticle(int no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		lectureBoardDTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select * from kh_noticeboard where no = ?"); 
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new lectureBoardDTO();
				article.setNo(rs.getInt("no"));
				article.setL_name(rs.getString("l_name"));
				article.setContent(rs.getString("content"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setResult(rs.getString("result"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	//공지사항 수정하는 쿼리
	public lectureBoardDTO modifyArticle(lectureBoardDTO l_DTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		lectureBoardDTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"update kh_lectureboard set l_name=?, professor=?, content=?, reg_date=?, result=? where num = ?"); 
			pstmt.setString(1, l_DTO.getL_name());
			pstmt.setString(2, l_DTO.getProfessor());
			pstmt.setString(3, l_DTO.getContent());			
			pstmt.setTimestamp(4, l_DTO.getReg_date());
			pstmt.setString(5, l_DTO.getResult());
			rs = pstmt.executeQuery();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	//공지사항 삭제 쿼리.
	public lectureBoardDTO deleteArticle(int no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		lectureBoardDTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"delete kh_lectureboard where no = ?"); 
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	
	// 휴가신청
		public void insert_vacationBoard(vacationDTO vDTO) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement(
	            	"insert into kh_vacation values (kh_vacation_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            pstmt.setString(1, vDTO.getName());
	            pstmt.setString(2, vDTO.getType());
	            pstmt.setString(3, vDTO.getMajor());
	            pstmt.setString(4, vDTO.getVacStart_yy());
	            pstmt.setString(5, vDTO.getVacStart_mm());
	            pstmt.setString(6, vDTO.getVacStart_dd());
	            pstmt.setString(7, vDTO.getVacEnd_yy());
	            pstmt.setString(8, vDTO.getVacEnd_mm());
	            pstmt.setString(9, vDTO.getVacEnd_dd());
	            pstmt.setString(10, vDTO.getVacation_reason());
	            pstmt.setTimestamp(11, vDTO.getReg_date());
	            pstmt.setString(12, vDTO.getResult());
	            pstmt.setString(13, vDTO.getId());
	            
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	        
	    }
		
	//휴가신청 게시판 리스트 (처리 전)
		public List<vacationDTO> vacationReqList() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<vacationDTO> list = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_vacation where result = '미처리' order by no desc");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list = new ArrayList<vacationDTO>();
					do {
						vacationDTO vDTO = new vacationDTO();
						vDTO.setNo(rs.getInt("no"));
						vDTO.setName(rs.getString("name"));
						vDTO.setType(rs.getString("type"));
						vDTO.setMajor(rs.getString("major"));
						vDTO.setVacStart_yy(rs.getString("VacStart_yy"));
						vDTO.setVacStart_mm(rs.getString("VacStart_mm"));
						vDTO.setVacStart_dd(rs.getString("VacStart_dd"));
						vDTO.setVacEnd_yy(rs.getString("VacEnd_yy"));
						vDTO.setVacEnd_mm(rs.getString("VacEnd_mm"));
						vDTO.setVacEnd_dd(rs.getString("VacEnd_dd"));
						vDTO.setVacation_reason(rs.getString("vacation_reason"));
						vDTO.setReg_date(rs.getTimestamp("reg_date"));
						vDTO.setResult(rs.getString("result"));
						vDTO.setId(rs.getString("id"));
						list.add(vDTO);
					} while (rs.next());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}

			return list;
		}
		
//휴가신청 게시판 리스트 (처리 후)
		public List<vacationDTO> vacationResultList() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<vacationDTO> list = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_vacation where result != '미처리' order by no desc");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list = new ArrayList<vacationDTO>();
					do {
						vacationDTO vDTO = new vacationDTO();
						vDTO.setNo(rs.getInt("no"));
						vDTO.setName(rs.getString("name"));
						vDTO.setType(rs.getString("type"));
						vDTO.setMajor(rs.getString("major"));
						vDTO.setVacStart_yy(rs.getString("VacStart_yy"));
						vDTO.setVacStart_mm(rs.getString("VacStart_mm"));
						vDTO.setVacStart_dd(rs.getString("VacStart_dd"));
						vDTO.setVacEnd_yy(rs.getString("VacEnd_yy"));
						vDTO.setVacEnd_mm(rs.getString("VacEnd_mm"));
						vDTO.setVacEnd_dd(rs.getString("VacEnd_dd"));
						vDTO.setVacation_reason(rs.getString("vacation_reason"));
						vDTO.setReg_date(rs.getTimestamp("reg_date"));
						vDTO.setResult(rs.getString("result"));
						vDTO.setId(rs.getString("id"));
						list.add(vDTO);
					} while (rs.next());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}

			return list;
		}
		
		//휴가 신청 수정하는 쿼리
		public vacationDTO modifyVacation(vacationDTO vDTO) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			vacationDTO article=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
				"update kh_vacation set VacStart_yy=?, VacStart_mm=?, VacStart_dd=?, VacEnd_yy=?, VacEnd_mm=?, VacEnd_dd=?, vacation_reason=?, reg_date=? where no=?"); 
				pstmt.setString(1, vDTO.getVacStart_yy());
	            pstmt.setString(2, vDTO.getVacStart_mm());
	            pstmt.setString(3, vDTO.getVacStart_dd());
	            pstmt.setString(4, vDTO.getVacEnd_yy());
	            pstmt.setString(5, vDTO.getVacEnd_mm());
	            pstmt.setString(6, vDTO.getVacEnd_dd());
				pstmt.setString(7, vDTO.getVacation_reason());
				pstmt.setTimestamp(8, vDTO.getReg_date());
				pstmt.setInt(9, vDTO.getNo());
				rs = pstmt.executeQuery();

			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			
			return article;
		}
		//휴가 신청 삭제 쿼리.
		public vacationDTO deleteVacation(int no) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			vacationDTO article=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
				"delete kh_vacation where no = ?"); 
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();

			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			
			return article;
		}
		
		//시퀀스 넘버로 휴가신청 게시글을 가져오는 쿼리.
		public vacationDTO getVacationArticle(int no) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			vacationDTO article=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
				"select * from kh_vacation where no=?"); 
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					article = new vacationDTO();
					article.setNo(rs.getInt("no"));
					article.setName(rs.getString("name"));
					article.setType(rs.getString("type"));
					article.setMajor(rs.getString("major"));
					article.setVacStart_yy(rs.getString("vacStart_yy"));
					article.setVacStart_mm(rs.getString("vacStart_mm"));
					article.setVacStart_dd(rs.getString("vacStart_dd"));
					article.setVacEnd_yy(rs.getString("vacEnd_yy"));
					article.setVacEnd_mm(rs.getString("vacEnd_mm"));
					article.setVacEnd_dd(rs.getString("vacEnd_dd"));
					article.setVacation_reason(rs.getString("vacation_reason"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setResult(rs.getString("result"));
					article.setId(rs.getString("id"));
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			
			return article;
		}
		
		//휴가 신청을 승인처리 해주는 쿼리
		public vacationDTO VacationResultSet(vacationDTO vDTO) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			vacationDTO article=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
				"update kh_vacation set result=? where no=?"); 
				pstmt.setString(1, vDTO.getResult());
				pstmt.setInt(2, vDTO.getNo());
				rs = pstmt.executeQuery();
	
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			
			return article;
		}

}
