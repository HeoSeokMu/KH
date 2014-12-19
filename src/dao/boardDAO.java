package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.lectureBoardDTO;

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
	
	// 공지 내용을 DB에 인서트
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
	
	// 공지 내용을 DB에서 가져옴
	public List<lectureBoardDTO> notice_BoardList() throws Exception {
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
	
	//세션 id로 이름만 가져오는 쿼리.
	public String getName(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = "";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select name from KH_MEMBER where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
				System.out.println("name == " + name);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return name;
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

}
