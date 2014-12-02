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

		public List<String> getNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_library");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList<String>();
							do{					
								articleList.add(rs.getString("name"));
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
			            pstmt.setString(8, library.getFile_orgname());
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

}

