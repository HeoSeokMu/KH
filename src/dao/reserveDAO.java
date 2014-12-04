package dao;

import java.sql.*;
import java.sql.Date;
import javax.sql.*;
import javax.naming.*;
import dto.reserveDTO;
import java.util.*; 

public class reserveDAO {

		private static reserveDAO instance = new reserveDAO();
		
		public static reserveDAO getInstance() {
			return instance;
		
		}
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
		}

		//예약내용 저장
		public void insertReserve(reserveDTO dto) throws Exception {
		        Connection conn = null;
		        PreparedStatement pstmt = null;
		        
		        try {
		            conn = getConnection();
		            
		            pstmt = conn.prepareStatement(
		            	"insert into KH_RESERVE values (?,?,?,?)");
		            pstmt.setString(1, dto.getB_num());
		            pstmt.setString(2, dto.getS_num());
		            pstmt.setString(3, dto.getEmail());
		            pstmt.setDate(4, dto.getDate());
		            pstmt.executeUpdate();
		        } catch(Exception ex) {
		            ex.printStackTrace();
		        } finally {
		            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		        }
		}
}