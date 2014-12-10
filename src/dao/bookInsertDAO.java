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
		
		private Connection getConnection(){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@khjob.iptime.org:7000:xe";
				String user = "java09";
				String password = "java09";
				
				conn = DriverManager.getConnection(url, user, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
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
			            	+ "values (library.nextval,?,?,?,?,?,?,?,?,'보관중','','0','',?)");
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
	}
