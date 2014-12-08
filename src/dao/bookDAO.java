package dao;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import dto.libraryDTO;

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
		
		//전체 글의 수
		public int getArticleCount() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x=0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from kh_library");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					x= rs.getInt(1); 
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//전체타입 검색 결과 글의수
		public int getSelectAllCount(String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String searchWord = "%"+word+"%";
			int x=0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from kh_library where BOOK_TITLE like ? or BOOK_WRITER like ?");
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					x= rs.getInt(1); 
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//서명타입 검색 결과 글의수
		public int getSelectTitleCount(String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String searchWord = "%"+word+"%";
			int x=0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from kh_library where BOOK_TITLE like ?");
				pstmt.setString(1, searchWord);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					x= rs.getInt(1); 
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//저자타입 검색 결과 글의수
		public int getSelectWriterCount(String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String searchWord = "%"+word+"%";
			int x=0;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from kh_library where BOOK_WRITER like ?");
				pstmt.setString(1, searchWord);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					x= rs.getInt(1); 
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return x;
		}
		
		//전체글
		public List<libraryDTO> getArticles(int start, int end) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select *from (select rownum r, a.* from (select * from kh_library order by reg_date desc) a) where r > ?  and r < ?");
						pstmt.setInt(1, start); 
						pstmt.setInt(2, end); 

						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(end); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getString("BOOK_ID"));
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
		
		//전체타입 검색결과
		public List getSelectAll(int start, int end, String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			String searchWord = "%"+word+"%";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select *from (select rownum r, a.* from (select * from (select *from kh_library where book_id like ? or book_writer like ?) order by reg_date desc) a) where r > ?  and r < ?");
						pstmt.setString(1, searchWord); 
						pstmt.setString(2, searchWord); 
						pstmt.setInt(3, start); 
						pstmt.setInt(4, end);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(end); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getString("BOOK_ID"));
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
		
		//서명타입 검색결과
		public List getSelectTitle(int start, int end, String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			String searchWord = "%"+word+"%";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select *from (select rownum r, a.* from (select * from (select *from kh_library where book_id like ?) order by reg_date desc) a) where r > ?  and r < ?");
						pstmt.setString(1, searchWord); 
						pstmt.setInt(2, start); 
						pstmt.setInt(3, end); 

						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(end); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getString("BOOK_ID"));
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
		
		//저자타입 검색결과
		public List getSelectWriter(int start, int end, String word) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			String searchWord = "%"+word+"%";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select *from (select rownum r, a.* from (select * from (select *from kh_library where book_writer like ?) order by reg_date desc) a) where r > ?  and r < ?");
						pstmt.setString(1, searchWord); 
						pstmt.setInt(2, start); 
						pstmt.setInt(3, end); 

						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(end); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getString("BOOK_ID"));
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
}