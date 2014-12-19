package dao;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import dto.libraryDTO;

import java.util.*; 

public class bookInsertDAO {

		private static bookInsertDAO instance = new bookInsertDAO();
		
		public static bookInsertDAO getInstance() {
			return instance;
		
		}
		private bookInsertDAO(){}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
		}

		
		
		//책등록
		public void bookInsert(libraryDTO library) throws Exception {
			        Connection conn = null;
			        PreparedStatement pstmt = null;
			        ResultSet rs = null;
			        int bookId = library.getBook_id();
			        int number=0;
			        String sql ="";


			        try {
			            conn = getConnection();
			            
			            
			            pstmt = conn.prepareStatement(
			            	"insert into KH_LIBRARY (book_id,book_title,book_location,book_writer,book_publisher,book_year,book_supplement,reg_date,isbn,loan,s_num,extension,turnin,book_img)"
			            	+ "values (library.nextval,?,?,?,?,?,?,?,?,'대출가능','','0','',?)");
			            pstmt.setString(1, library.getBook_title());
			            pstmt.setString(2, library.getBook_location());
			            pstmt.setString(3, library.getBook_writer());
			            pstmt.setString(4, library.getBook_publisher());
			            pstmt.setString(5, library.getBook_year());
			            pstmt.setString(6, library.getBook_supplement());
			            pstmt.setTimestamp(7, library.getReg_date());
			            pstmt.setInt(8, library.getIsbn());
			            pstmt.setString(9, library.getBook_img());
			            pstmt.executeUpdate();
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        } finally {
			            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			        }
			        
			    }

		//책 신청 등록
		public void bookRequest(libraryDTO library) throws Exception {
			        Connection conn = null;
			        PreparedStatement pstmt = null;
			        ResultSet rs = null;
			        int bookId = library.getBook_id();
			        int number=0;
			        String sql ="";


			        try {
			            conn = getConnection();
			            
			            
			            pstmt = conn.prepareStatement(
			            	"insert into KH_LIBRARYREQUEST (book_id,book_title,book_writer,book_publisher,reg_date,isbn,bookcheck,id,name,s_phone)"
			            	+ "values (bookRequest_no_seq.nextval,?,?,?,?,?,'0',?,?,?)");
			            pstmt.setString(1, library.getBook_title());
			            pstmt.setString(2, library.getBook_writer());
			            pstmt.setString(3, library.getBook_publisher());
			            pstmt.setTimestamp(4, library.getReg_date());
			            pstmt.setInt(5, library.getIsbn());
			            pstmt.setString(6, library.getId());
			            pstmt.setString(7, library.getName());
			            pstmt.setString(8, library.getS_phone());
			            pstmt.executeUpdate();
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        } finally {
			            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			        }
			        
			    }


		

//책 등록 번호 자동증가 부분
		public int plusNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x = 0;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select max(book_id) from kh_library");
				
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
		
		//책 신청 등록 번호 자동증가 부분
				public int requestNum() throws Exception {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					int x = 0;

					try {
						conn = getConnection();
						pstmt = conn.prepareStatement("select max(book_id) from kh_libraryRequest");
						
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
		
	
		//등록한 책 내역 보기
		public libraryDTO getBookView(String book_id) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			libraryDTO book=null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_library where book_id = ?");
				pstmt.setString(1, book_id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					book = new libraryDTO();
					book.setBook_id(rs.getInt("book_id"));
					book.setBook_title(rs.getString("book_title"));
					book.setBook_location(rs.getString("book_location"));
					book.setBook_writer(rs.getString("book_writer"));
					book.setBook_publisher(rs.getString("book_publisher"));
					book.setBook_year(rs.getString("book_year"));
					book.setBook_supplement(rs.getString("book_supplement"));
					book.setReg_date(rs.getTimestamp("reg_date"));
					book.setIsbn(rs.getInt("isbn"));
					book.setBook_img(rs.getString("book_img"));
				}
			}catch(Exception ex){
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}return book;
		}

		
		
		
		//등록한 책 삭제
		public libraryDTO bookDelete(String book_id) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			libraryDTO book=null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from kh_library where book_id = ?");
				pstmt.setString(1, book_id);
				rs = pstmt.executeQuery();
				
			}catch(Exception ex){
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}return book;
		}
		//신청한 책 삭제
		public libraryDTO bookRequestDelete(String book_id) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			libraryDTO book=null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from kh_libraryRequest where book_id = ?");
				pstmt.setString(1, book_id);
				rs = pstmt.executeQuery();
				
			}catch(Exception ex){
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}return book;
		}
		

		//책 수정
		public libraryDTO bookModify(libraryDTO book) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("update kh_library set book_title=?,book_location=?,book_writer=?,book_publisher=?,book_year=?,book_supplement=?,isbn=?,book_img=? where book_id=?");
		        pstmt.setString(1, book.getBook_title());
		        pstmt.setString(2, book.getBook_location());
		        pstmt.setString(3, book.getBook_writer());
		        pstmt.setString(4, book.getBook_publisher());
		        pstmt.setString(5, book.getBook_year());
		        pstmt.setString(6, book.getBook_supplement());
		        pstmt.setInt(7, book.getIsbn());
		        pstmt.setString(8, book.getBook_img());
		        pstmt.setInt(9, book.getBook_id());
		        pstmt.executeUpdate();
				
			}catch(Exception ex){
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}return book;
		}
		//책 신청 리스트
		public List<libraryDTO> getRequestArticles() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			try {
				conn = getConnection();
					pstmt = conn.prepareStatement("select * from kh_libraryrequest order by reg_date desc ");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getInt("BOOK_ID"));
								article.setBook_title(rs.getString("BOOK_TITLE"));
								article.setBook_writer(rs.getString("BOOK_WRITER"));
								article.setBook_publisher(rs.getString("BOOK_PUBLISHER"));
								article.setReg_date(rs.getTimestamp("REG_DATE"));
								article.setIsbn(rs.getInt("ISBN"));
								article.setBookcheck(rs.getString("bookcheck"));
								article.setId(rs.getString("id"));
								article.setName(rs.getString("name"));
								article.setS_phone(rs.getString("s_phone"));
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
		
		//나의 책 신청 리스트
		public List<libraryDTO> getRequestArticles(int id) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			try {
				conn = getConnection();
					pstmt = conn.prepareStatement("select * from kh_libraryrequest where id = ? order by reg_date desc ");
					pstmt.setInt(1, id);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(); 
							do{ 
								libraryDTO article= new libraryDTO();
								article.setBook_id(rs.getInt("BOOK_ID"));
								article.setBook_title(rs.getString("BOOK_TITLE"));
								article.setBook_writer(rs.getString("BOOK_WRITER"));
								article.setBook_publisher(rs.getString("BOOK_PUBLISHER"));
								article.setReg_date(rs.getTimestamp("REG_DATE"));
								article.setIsbn(rs.getInt("ISBN"));
								article.setBookcheck(rs.getString("bookcheck"));
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
		
		//책신청 승인
		public libraryDTO bookRequestOk(int book_id) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			libraryDTO book=null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("update kh_libraryrequest set bookcheck = 1 where book_id = ?");
				pstmt.setInt(1, book_id);
				rs = pstmt.executeQuery();
				
			}catch(Exception ex){
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}return book;
		}
		
		//책신청 반려
				public libraryDTO bookRequestNo(int book_id) throws Exception{
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					libraryDTO book=null;
					try{
						conn = getConnection();
						pstmt = conn.prepareStatement("update kh_libraryrequest set bookcheck = 2 where book_id = ?");
						pstmt.setInt(1, book_id);
						rs = pstmt.executeQuery();
						
					}catch(Exception ex){
						ex.printStackTrace();
					} finally {
						if (rs != null) try { rs.close(); } catch(SQLException ex) {}
						if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
						if (conn != null) try { conn.close(); } catch(SQLException ex) {}
					}return book;
				}
		
	}
