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
	            pstmt.setString(1, "대출중");
	            pstmt.setString(2, dto.getS_num());
	            pstmt.setDate(3, dto.getTurnin());
	            pstmt.setInt(4, dto.getBook_id());
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
		}
		
		public void insertNotice(reserveDTO dto) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement("insert into kh_reserve values(?,?,?,?)");
	            pstmt.setString(1, dto.getB_num());
	            pstmt.setString(2, dto.getS_num());
	            pstmt.setString(3, dto.getEmail());
	            pstmt.setTimestamp(4, dto.getRent());
	            
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
		}
		
		public String getEmail(String s_num) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String email = null;
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select email from kh_member where id = ?");
					pstmt.setString(1, s_num); 
						rs = pstmt.executeQuery();
						if (rs.next()) {
							email=rs.getString("email");
						}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return email;
		}
		
		public void turnin(int book_id) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement(
	            	"update kh_library set loan = ?, s_num = ?, turnin = ? where book_id = ? ");
	            pstmt.setString(1, "대출가능");
	            pstmt.setString(2, "0");
	            pstmt.setDate(3, null);
	            pstmt.setInt(4, book_id);
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
		}
		
		public List getEmailList(String book_id) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List list = new ArrayList();
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select email from kh_reserve where b_num = ?");
					pstmt.setString(1, book_id); 
					rs = pstmt.executeQuery();
					if (rs.next()) {
						do{
							list.add(rs.getString("email"));
						}while(rs.next());
					}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return list;
		}
		public String getBook_name(int book_id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String book_name = null;
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select book_title from kh_library where book_id = ?");
					pstmt.setInt(1, book_id); 
						rs = pstmt.executeQuery();
						if (rs.next()) {
								book_name = rs.getString("book_title");
						}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return book_name;
		}
		public int getNoticeListCount(String memId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int i=0;
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select count(*) from kh_library li, kh_reserve re where re.s_num = ? and li.book_id = re.b_num");
					pstmt.setString(1, memId);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						i= rs.getInt(1);
					}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return i;
		}
		
		public List getNoticeList(String memId) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List list = new ArrayList();
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select li.book_img, li.book_title, li.book_id, re.email, re.rent from kh_library li, kh_reserve re where re.s_num = ? and li.book_id = re.b_num");
					pstmt.setString(1, memId);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						do{
							reserveDTO article= new reserveDTO();
							article.setBook_img(rs.getString("book_img"));
							article.setB_num(rs.getString("book_title"));
							article.setEmail(rs.getString("email"));
							article.setRent(rs.getTimestamp("rent"));
							list.add(article); 
						}while(rs.next());
					}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return list;
		}
		public void noticeDelete(String memId, String b_num) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement("delete kh_reserve where b_num = ? and s_num = ?");
	            pstmt.setString(1, b_num);
	            pstmt.setString(2, memId);
	            pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
			
		}
		public int getNoticeCount(String b_num, String s_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int i=0;
			try {
				conn = getConnection();
				
					pstmt = conn.prepareStatement("select count(*) from kh_reserve where b_num = ? and s_num = ?");
					pstmt.setString(1, b_num);
					pstmt.setString(2, s_num);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						i= rs.getInt(1);
					}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return i;
		}
		
		public List getTurnin(Timestamp tDate ) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List list = new ArrayList();
			try {
				conn = getConnection();
					pstmt = conn.prepareStatement("select li.book_title, mem.email from kh_library li, kh_member mem where turnin < ? and mem.id = li.s_num");
					pstmt.setTimestamp(1, tDate);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						do{
							libraryDTO article= new libraryDTO();
							list.add(article); 
						}while(rs.next());
					}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return list;
		}
		
		public List<libraryDTO> getLoanList(String memId) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("select *from kh_library where s_num = ?");
				pstmt.setString(1, memId);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					articleList = new ArrayList(); 
					do{ 
						libraryDTO article= new libraryDTO();
						article.setBook_id(rs.getInt("BOOK_ID"));
						article.setBook_title(rs.getString("BOOK_TITLE"));
						article.setBook_img(rs.getString("Book_img"));
						article.setTurnin(rs.getDate("TURNIN"));
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
}