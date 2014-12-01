package dao;

import java.sql.*;
import java.sql.Date;

import javax.sql.*;
import javax.naming.*;

import dto.rentDTO;

import java.util.*; 

public class rentDAO {

		private static rentDAO instance = new rentDAO();
		
		public static rentDAO getInstance() {
			return instance;
		
		}
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
		}
		
		
		//전체 학번 리스트
		public List<String> getNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select num from kh_member");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							articleList = new ArrayList<String>();
							do{					
								articleList.add(rs.getString("num"));
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
		
		//대여내용 저장
		public void insertRent(rentDTO dto) 
			    throws Exception {
			        Connection conn = null;
			        PreparedStatement pstmt = null;
			        
			        try {
			            conn = getConnection();
			            
			            pstmt = conn.prepareStatement(
			            	"insert into KH_RENT values (?,?,?,?)");
			            pstmt.setString(1, dto.getB_num());
			            pstmt.setString(2, dto.getS_num());
			            pstmt.setTimestamp(3, dto.getTurnin());
			            pstmt.setInt(4, dto.getExtension());
			            pstmt.executeUpdate();
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        } finally {
			            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			        }
			    }
		
}

