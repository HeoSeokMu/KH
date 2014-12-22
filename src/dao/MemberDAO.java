package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.RestReturnBoard_DTO;
import dto.memberDTO;
import dto.noticeboard_DTO;
import dto.postDTO;

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
            	"insert into KH_MEMBER values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, member.getType());
            pstmt.setString(2, member.getNum1());
            pstmt.setString(3, member.getNum2());
            pstmt.setInt(4, member.getNum3());
            pstmt.setString(5, member.getId());
            pstmt.setString(6, member.getPassword());
            pstmt.setString(7, member.getName());
            pstmt.setString(8, member.getSex());
            pstmt.setString(9, member.getEmail());
            pstmt.setString(10, member.getS_phone());
            pstmt.setString(11, member.getP_phone());
            pstmt.setTimestamp(12, member.getReg_date());
            pstmt.setString(13, member.getBirth_yy());
            pstmt.setString(14, member.getBirth_mm());
            pstmt.setString(15, member.getBirth_dd());
            pstmt.setString(16, member.getPro_img());
            pstmt.setString(17, member.getAddr());
            pstmt.setString(18, member.getPost());
            pstmt.setString(19, member.getMajor());
            pstmt.setString(20, member.getEnter_way());
            pstmt.setString(21, member.getBefore_school());
            
            pstmt.setInt(22, member.getGrade());
            pstmt.setString(23, member.getStatus());
            pstmt.setTimestamp(24, member.getEnd_date());
            pstmt.setInt(25, member.getSemester());
            pstmt.setInt(26, member.getRest_count());
            
            pstmt.setString(27, member.getParent_name());
            pstmt.setString(28, member.getParent_job());
            pstmt.setString(29, member.getP_addr());
            pstmt.setString(30, member.getP_post());
            
            pstmt.setString(31, member.getMajor_kind());
            pstmt.setInt(32, member.getFinish_point());
            
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
	
	//로그인 쿼리. 학번, 비밀번호, 회원유형을 가져와 체크.
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

	public List<String> getPost(String sch) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List postList = null;
		String allsch = "%"+sch+"%"+"동"+"%";
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
					dto.setType(rs.getString("type"));
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
	//id로 회원 정보 가져오는 쿼리.
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
				mDTO.setEmail(rs.getString("email"));
				mDTO.setS_phone(rs.getString("s_phone"));
				mDTO.setP_phone(rs.getString("p_phone"));
				mDTO.setReg_date(rs.getTimestamp("reg_date"));
				mDTO.setBirth_yy(rs.getString("birth_yy"));
				mDTO.setBirth_mm(rs.getString("birth_mm"));
				mDTO.setBirth_dd(rs.getString("birth_dd"));
				mDTO.setPro_img(rs.getString("pro_img"));
				mDTO.setAddr(rs.getString("addr"));
				mDTO.setPost(rs.getString("post"));
				mDTO.setMajor(rs.getString("major"));
				mDTO.setEnter_way(rs.getString("enter_way"));
				mDTO.setBefore_school(rs.getString("before_school"));
				mDTO.setGrade(rs.getInt("grade"));
				mDTO.setStatus(rs.getString("status"));
				mDTO.setEnd_date(rs.getTimestamp("end_date"));
				mDTO.setSemester(rs.getInt("semester"));
				mDTO.setRest_count(rs.getInt("rest_count"));
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
	
	public memberDTO student_info(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		memberDTO mDTO = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select id, name, email, s_phone, addr, major, grade, status, semester, rest_count from kh_member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mDTO = new memberDTO();			// DB에 있는 레코드를 DTO에 저장
				mDTO.setId(rs.getString("id"));
				mDTO.setName(rs.getString("name"));
				mDTO.setEmail(rs.getString("email"));
				mDTO.setS_phone(rs.getString("s_phone"));
				mDTO.setAddr(rs.getString("addr"));
				mDTO.setMajor(rs.getString("major"));
				mDTO.setGrade(rs.getInt("grade"));
				mDTO.setStatus(rs.getString("status"));
				mDTO.setSemester(rs.getInt("semester"));
				mDTO.setRest_count(rs.getInt("rest_count"));
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
	
	// 공지 내용을 DB에 인서트
	public void insert_NoticeBoard(noticeboard_DTO nb_DTO) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"insert into KH_NOTICEBOARD values (autonum.NEXTVAL,?,?,?,?)");
            pstmt.setString(1, nb_DTO.getTitle());
            pstmt.setString(2, nb_DTO.getContent());
            pstmt.setTimestamp(3, nb_DTO.getReg_date());
            pstmt.setString(4, nb_DTO.getWriter());
            
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
	
	//
	public void myInfo_Edit(String id, String email, String s_phone){
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"update kh_member set email = ?, s_phone = ? where id = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, s_phone);
            pstmt.setString(3, id);
            
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	}
	
	// 공지 내용을 DB에서 가져옴
	public List<noticeboard_DTO> notice_BoardList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<noticeboard_DTO> noticeBoard_List = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from KH_NOTICEBOARD order by num desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				noticeBoard_List = new ArrayList<noticeboard_DTO>();
				do {
					noticeboard_DTO dto = new noticeboard_DTO();
					dto.setNum(rs.getInt("num"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setWriter(rs.getString("writer"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					noticeBoard_List.add(dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}

		return noticeBoard_List;
	}
	
	//시퀀스 넘버로 게시글을 가져오는 쿼리.
	public noticeboard_DTO getArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		noticeboard_DTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select * from kh_noticeboard where num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new noticeboard_DTO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setTitle(rs.getString("title"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setContent(rs.getString("content"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	//공지사항 수정하는 쿼리
	public noticeboard_DTO modifyArticle(noticeboard_DTO nb_DTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		noticeboard_DTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"update kh_noticeboard set title=?, reg_date=?, content=? where num = ?"); 
			pstmt.setString(1, nb_DTO.getTitle());
			pstmt.setTimestamp(2, nb_DTO.getReg_date());
			pstmt.setString(3, nb_DTO.getContent());			
			pstmt.setInt(4, nb_DTO.getNum());
			rs = pstmt.executeQuery();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	//공지사항 삭제 쿼리.
	public noticeboard_DTO deleteArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		noticeboard_DTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"delete kh_noticeboard where num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return article;
	}
	
	public void insertRestReturnBoard(RestReturnBoard_DTO rrb) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
	        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"insert into kh_restreturn_school_board values(kh_restreturn_num.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, rrb.getId());
            pstmt.setString(2, rrb.getName());
            pstmt.setString(3, rrb.getMajor());
            pstmt.setInt(4, rrb.getGrade());
            pstmt.setString(5, rrb.getEmail());
            pstmt.setString(6, rrb.getPhone());
            pstmt.setString(7, rrb.getAddr());
            pstmt.setString(8, rrb.getTime());
            pstmt.setString(9, rrb.getWhy());
            pstmt.setString(10, rrb.getWhy_detail());
            pstmt.setString(11, rrb.getResult());
            pstmt.setTimestamp(12, rrb.getReg_date());
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
	
	// 휴학신청 리스트
	public List<RestReturnBoard_DTO> RestReturn_BoardList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RestReturnBoard_DTO> rrb_List = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select num, major, name, id, grade, reg_date from kh_restreturn_school_board where result = '미처리' order by num desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rrb_List = new ArrayList<RestReturnBoard_DTO>();
				do {
					RestReturnBoard_DTO dto = new RestReturnBoard_DTO();
					dto.setNum(rs.getInt("num"));
					dto.setMajor(rs.getString("major"));
					dto.setName(rs.getString("name"));
					dto.setId(rs.getString("id"));
					dto.setGrade(rs.getInt("grade"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					rrb_List.add(dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return rrb_List;
	}
	
	// 휴학신청 처리 리스트
	public List<RestReturnBoard_DTO> RestReturn_Board_Processing_List() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RestReturnBoard_DTO> rrb_List = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select num, major, name, id, grade, reg_date from kh_restreturn_school_board where result != '미처리' order by num desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rrb_List = new ArrayList<RestReturnBoard_DTO>();
				do {
					RestReturnBoard_DTO dto = new RestReturnBoard_DTO();
					dto.setNum(rs.getInt("num"));
					dto.setMajor(rs.getString("major"));
					dto.setName(rs.getString("name"));
					dto.setId(rs.getString("id"));
					dto.setGrade(rs.getInt("grade"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					rrb_List.add(dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return rrb_List;
	}
	
	//휴학 결과 수정하는 쿼리
	public void modify_RestReturnBoard(RestReturnBoard_DTO rrb_DTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		noticeboard_DTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"update kh_restreturn_school_board set result=? where num = ?");
			pstmt.setString(1, rrb_DTO.getResult());
			pstmt.setInt(2, rrb_DTO.getNum());
			rs = pstmt.executeQuery();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
}
