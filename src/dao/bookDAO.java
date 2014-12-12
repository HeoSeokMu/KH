package dao;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import dto.libraryDTO;
import dto.memberDTO;
import dto.reserveDTO;

import java.util.*; 

public class bookDAO {

		private static bookDAO instance = new bookDAO();
		
		public static bookDAO getInstance() {
			return instance;
		
		}
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
		}

		public List<libraryDTO> getArticles(String searchType, String keyword) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			if(keyword == null){
				keyword = "";
			}
			String perKeyword = "%"+keyword+"%";
			try {
				conn = getConnection();
				if(searchType == "title"){
					pstmt = conn.prepareStatement("select * from kh_library where book_title like ? order by reg_date desc ");
					pstmt.setString(1, perKeyword); 
				}else if(searchType == "writer"){
					pstmt = conn.prepareStatement("select * from kh_library where book_writer like ? order by reg_date desc ");
					pstmt.setString(1, perKeyword); 
				}else{
					pstmt = conn.prepareStatement("select * from kh_library where book_writer like ? or book_title like ? order by reg_date desc ");
					pstmt.setString(1, perKeyword); 
					pstmt.setString(2, perKeyword);
				}
				
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getInt("BOOK_ID"));
								article.setBook_title(rs.getString("BOOK_TITLE"));
								article.setBook_location(rs.getString("BOOK_LOCATION"));
								article.setBook_writer(rs.getString("BOOK_WRITER"));
								article.setBook_publisher(rs.getString("BOOK_PUBLISHER"));
								article.setBook_year(rs.getString("BOOK_YEAR"));
								article.setBook_supplement(rs.getString("BOOK_SUPPLEMENT"));
								article.setReg_date(rs.getTimestamp("REG_DATE"));
								article.setIsbn(rs.getInt("ISBN"));
								article.setLoan(rs.getString("LOAN"));
								article.setS_num(rs.getString("S_NUM"));
								article.setExtension(rs.getInt("EXTENSION"));
								article.setTurnin(rs.getDate("TURNIN"));
								article.setBook_img(rs.getString("Book_img"));
								articleList.add(article); 
							}while(rs.next());
						}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}

			
			return articleList;
		}
		
		public memberDTO getSelectInform(String s_num) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			memberDTO dto = new memberDTO();
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select * from kh_member where id = ?");
					pstmt.setString(1, s_num); 
				
						rs = pstmt.executeQuery();
						if (rs.next()) {
								dto.setName(rs.getString("name"));
								dto.setS_phone(rs.getString("s_phone"));
						}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}

			
			return dto;
		}
		
		public void insertLoan(libraryDTO dto) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement(
	            	"update kh_library set loan = ?, s_num = ?, turnin = ? where book_id = ? ");
	            pstmt.setString(1, "´ë¿©Áß");
	            pstmt.setString(2, dto.getS_num());
	            pstmt.setDate(3, dto.getTurnin());
	            pstmt.setString(4, dto.getBook_id());
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	}
}