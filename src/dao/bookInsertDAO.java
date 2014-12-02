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
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
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
			            pstmt.setInt(1, library.getBook_id());
			            pstmt.setString(2, library.getBook_title());
			            pstmt.setString(3, library.getBook_location());
			            pstmt.setString(4, library.getBook_writer());
			            pstmt.setString(5, library.getBook_publisher());
			            pstmt.setInt(6, library.getBook_year());
			            pstmt.setString(7, library.getBook_supplement());
			            pstmt.setString(8, library.getFile_orgname());
			            pstmt.setTimestamp(9, library.getInsert_year());
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

