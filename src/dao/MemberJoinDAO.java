package dao;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import dto.memberDTO;

import java.util.*; 

public class MemberJoinDAO {

		private static MemberJoinDAO instance = new MemberJoinDAO();
		
		public static MemberJoinDAO getInstance() {
			return instance;
		
		}
		private Connection getConnection() throws Exception {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/orcl");
			return ds.getConnection();
		}
		
		//회원 리스트
		public List<String> getNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from kh_member");
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
		
		//회원 가입 메서드
		public void insertMember(memberDTO member) throws Exception {
			        Connection conn = null;
			        PreparedStatement pstmt = null;
			        
			        try {
			            conn = getConnection();
			            
			            pstmt = conn.prepareStatement(
			            	"insert into KH_MEMBER values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			            pstmt.setString(1, member.getType());
			            pstmt.setString(2, member.getNum1());
			            pstmt.setString(3, member.getNum2());
			            pstmt.setInt(4, member.getNum3());
			            pstmt.setString(5, member.getS_num());
			            pstmt.setString(6, member.getPassword());
			            pstmt.setString(7, member.getName());
			            pstmt.setString(8, member.getSex());
			            pstmt.setString(9, member.getE_mail());
			            pstmt.setString(10, member.getS_phone());
			            pstmt.setString(11, member.getP_phone());
			            pstmt.setTimestamp(12, member.getReg_date());
			            pstmt.setString(13, member.getBirth_yy());
			            pstmt.setString(14, member.getBirth_mm());
			            pstmt.setString(15, member.getBirth_dd());
			            pstmt.setString(16, member.getPro_img());
			            pstmt.setString(17, member.getAddress());
			            pstmt.setString(18, member.getPost());
			            pstmt.setString(19, member.getMajor());
			            pstmt.setString(20, member.getEnter_way());
			            pstmt.setString(21, member.getBefore_school());
			            pstmt.executeUpdate();
			        } catch(Exception ex) {
			            ex.printStackTrace();
			        } finally {
			            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
			        }
			        
			    }
		
		public int plusNum() throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String> articleList=null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select num from kh_member where num = ?");
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

			
			return plusNum();
		}
}
