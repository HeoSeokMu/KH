package dao;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import dto.memberDTO;
import dto.postDTO;

import java.util.*;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;

	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
		return ds.getConnection();
	}

	public List<String> getId() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from kh_member");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<String>();
				do {
					articleList.add(rs.getString("name"));
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		return articleList;
	}

	//회원등록 쿼리.
	
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
            pstmt.setString(5, member.getId());
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
	
	//회원등록에 쓰이는 번호 자동증가 쿼리. 학과, 부서와 회원 유형을 기준으로 가장 큰 번호를 가져온다. 자바 클래스에서  +1을 처리 한다.
	
	public int plusNum3(String num2, String type) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num3) from kh_member where num2 = ? and type = ?");
			pstmt.setString(1, num2);
			pstmt.setString(2, type);
			
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
	
	public int Login_check(String id, String pw, String type) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPassword = "";
		int x = 3;
		
		System.out.println("Login_check ==========================");
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pw from KH_MEMBER where id = ? and type = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			System.out.println("id : " + id);
			System.out.println("type : " + type);
			if (rs.next()) {
				dbPassword = rs.getString("pw");
				System.out.println("dbPassword : " + dbPassword + " / pw : " +pw);
				if (dbPassword.equals(pw)){
					x = 1; // 인증 성공
				}else{
					x = 2; // 비밀번호 틀림
				}
			}else{
				x = 3;// 해당 아이디 없음
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return x;
	}
<<<<<<< HEAD

	public List getPost(String sch) throws Exception {
=======
	public List<String> getPost() throws Exception {
>>>>>>> c8c38f44b6a628ec6f038e17638952c47998963b
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List postList = null;
		String allsch = "%"+sch+"%";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from kh_post where addr like ?");
			pstmt.setString(1, allsch);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				postList = new ArrayList();
				do {
					postDTO dto = new postDTO();
					dto.setAddr(rs.getString("addr"));
					dto.setZipcode(rs.getString("zipcode"));                       
					postList.add(dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		return postList;
	}
	
	public memberDTO member_info(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		memberDTO mDTO = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from kh_member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mDTO = new memberDTO();			// DB에 있는 레코드를 DTO에 저장
				mDTO.setType(rs.getString("type"));
				mDTO.setId(rs.getString("id"));
				mDTO.setPassword(rs.getString("pw"));
				mDTO.setName(rs.getString("name"));
				mDTO.setSex(rs.getString("sex"));
				mDTO.setE_mail(rs.getString("email"));
				mDTO.setS_phone(rs.getString("s_phone"));
				mDTO.setP_phone(rs.getString("p_phone"));
				mDTO.setReg_date(rs.getTimestamp("reg_date"));
				mDTO.setBirth_yy(rs.getString("birth_yy"));
				mDTO.setBirth_mm(rs.getString("birth_mm"));
				mDTO.setBirth_dd(rs.getString("birth_dd"));
				mDTO.setPro_img(rs.getString("pro_img"));
				mDTO.setAddress(rs.getString("addr"));
				mDTO.setPost(rs.getString("post"));
				mDTO.setMajor(rs.getString("major"));
				mDTO.setEnter_way(rs.getString("enter_way"));
				mDTO.setBefore_school(rs.getString("before_school"));
			}
			
		} catch(Exception ex) { 
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return mDTO;
	}
}
