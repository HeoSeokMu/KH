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

		
		
		
		public void bookInsert(libraryDTO library) throws Exception {
			        Connection conn = null;
			        PreparedStatement pstmt = null;
			        
			        try {
			            conn = getConnection();
			            
			            pstmt = conn.prepareStatement(
			            	"insert into KH_LIBRARY values (?,?,?,?,?,?,?,?,?,?)");
			            pstmt.setString(1, library.getBook_id());
			            pstmt.setString(2, library.getBook_title());
			            pstmt.setString(3, library.getBook_location());
			            pstmt.setString(4, library.getBook_writer());
			            pstmt.setString(5, library.getBook_publisher());
			            pstmt.setInt(6, library.getBook_year());
			            pstmt.setString(7, library.getBook_supplement());
			            pstmt.setInt(8, library.getImagename());
			            pstmt.setTimestamp(9, library.getReg_date());
			            pstmt.setInt(10, library.getIsbn());
			            pstmt.executeUpdate();
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        } finally {
			            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			        }
			        
			    }

		

		public List getArticles(int start, int end) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(
						"select book_id,book_title,book_location,book_writer,book_publisher,book_year,book_supplement,imagename,reg_date,isbn,r "
						+
						"from (select book_id,book_title,book_location,book_writer,book_publisher,book_year,book_supplement,imagename,reg_date,isbn,rownum r " +
						"from (select book_id,book_title,book_location,book_writer,book_publisher,book_year,book_supplement,imagename,reg_date,isbn " +
						"from kh_library order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
						pstmt.setInt(1, start); 
						pstmt.setInt(2, end); 

						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList(end); 
							do{ 
								libraryDTO library= new libraryDTO();
								library.setBook_id(rs.getString("book_id"));
								library.setBook_title(rs.getString("book_title"));
								library.setBook_location(rs.getString("book_location"));
								library.setBook_writer(rs.getString("book_writer"));
								library.setBook_publisher(rs.getString("book_publisher"));
								library.setBook_year(rs.getInt("book_year"));
								library.setBook_supplement(rs.getString("book_supplement"));
								library.setImagename(rs.getInt("imagename"));
								library.setReg_date(rs.getTimestamp("reg_date"));
								library.setIsbn(rs.getInt("isbn"));
								articleList.add(library); 
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
		
		public List<String> getNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> bookInsertList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_member");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							bookInsertList = new ArrayList<String>();
							do{					
								bookInsertList.add(rs.getString("num"));
							}while(rs.next());
						}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return bookInsertList;
		}
		
		public void bookInsertModify(libraryDTO library) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("update kh_library set book_title=?, book_location=?, book_writer=?, book_publisher=?, book_year=?, book_supplement=?, imagename=?, isbn=? where book_id=?");
				
						pstmt.setString(1, library.getBook_title());
						pstmt.setString(2, library.getBook_location());
						pstmt.setString(3, library.getBook_writer());
						pstmt.setString(3, library.getBook_publisher());
						pstmt.setInt(4, library.getBook_year());
						pstmt.setString(5, library.getBook_supplement());
						pstmt.setInt(6, library.getImagename());
						pstmt.setInt(7, library.getIsbn());
						pstmt.executeUpdate();
						
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
		}
		
		public String bookDelete(String book_id)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from kh_library where book_id=?");
				pstmt.setString(1, book_id);
				pstmt.executeUpdate();
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			}
			return book_id;
			
		}
}
