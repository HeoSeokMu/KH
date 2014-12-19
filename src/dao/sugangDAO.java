package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.stuDTO;
import dto.sugangDTO;

public class sugangDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static sugangDAO instance = new sugangDAO();
		
	public static sugangDAO getInstance() {
		return instance;
		
		
	}
	
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
	
	public List<sugangDTO> getList(String code, int grade) throws SQLException{
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		sugangDTO dto = null;
		int countList = 0;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from lecture_"+code+" where y_grade=?");
			pstmt.setInt(1, grade);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new sugangDTO();
				dto.setM_code(rs.getString("m_code"));	
				dto.setL_type(rs.getString("l_type"));
				dto.setL_code(rs.getString("l_code"));	
				dto.setL_name(rs.getString("l_name"));	
				dto.setProfessor(rs.getString("professor"));	
				dto.setL_room(rs.getString("l_room"));	
				dto.setY_grade(rs.getInt("y_grade"));	
				dto.setF_grade(rs.getInt("f_grade"));	
				dto.setSemester(rs.getInt("semester"));
				dto.setL_start(rs.getInt("l_start")); 	
				dto.setL_end(rs.getInt("l_end"));	
				dto.setL_day(rs.getString("l_day"));	
				dto.setIn_stu(rs.getInt("in_stu"));	
				dto.setLimit_stu(rs.getInt("limit_stu"));	
				dto.setS_date(rs.getString("s_date"));	
				dto.setL_date(rs.getString("l_date"));
				countList += 1;
				dto.setCount(countList);
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception s){}
		}	
		return list;
	}
	
	public int setStu(stuDTO stu){
		
		int result = 0;
		try{	
			conn = getConnection();			
			pstmt = conn.prepareStatement("insert into grade_"+stu.getStu_grade()+" values (?,?,?,?,?,?,?)");
			pstmt.setString(1,stu.getStu_num());
			pstmt.setString(2,stu.getStu_code());
			pstmt.setString(3,stu.getStu_grade());
			pstmt.setString(4,stu.getStu_name() );
			pstmt.setInt(5,stu.getSubject_sum());
			pstmt.setInt(6,stu.getHakjum_sum() );
			pstmt.setString(7,stu.getAllcode());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch(Exception s){}
		}
		return result;
	}
	
	public List<sugangDTO> getSugangList(String number, String grade){
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		sugangDTO dto = null;
		
		int countList = 0;
		
		String code = null;
		String sub_code[] = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select code from grade_"+grade+" where num=?");
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
	
			while(rs.next()){
				code = rs.getString("code");
			}
			
			sub_code = code.split(",");
			
			for(int i=0; i<sub_code.length; i++){
				String value[] = sub_code[i].split("=");
			
				pstmt = conn.prepareStatement("select * from lecture_"+value[1]+" where l_code=?");
				pstmt.setString(1,value[0]);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					dto = new sugangDTO();
					dto.setM_code(rs.getString("m_code"));	
					dto.setL_type(rs.getString("l_type"));
					dto.setL_code(rs.getString("l_code"));	
					dto.setL_name(rs.getString("l_name"));	
					dto.setProfessor(rs.getString("professor"));	
					dto.setL_room(rs.getString("l_room"));	
					dto.setY_grade(rs.getInt("y_grade"));	
					dto.setF_grade(rs.getInt("f_grade"));	
					dto.setSemester(rs.getInt("semester"));
					dto.setL_start(rs.getInt("l_start")); 	
					dto.setL_end(rs.getInt("l_end"));	
					dto.setL_day(rs.getString("l_day"));	
					dto.setIn_stu(rs.getInt("in_stu"));	
					dto.setLimit_stu(rs.getInt("limit_stu"));	
					dto.setS_date(rs.getString("s_date"));	
					dto.setL_date(rs.getString("l_date"));
					countList += 1;
					dto.setCount(countList);
					list.add(dto);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception s){s.printStackTrace();}
		}
	
		return list;
	}
	
	public stuDTO getstu(String grade, String number){
		stuDTO stu = new stuDTO();
		
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from grade_"+grade+" where num=?");
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				stu.setStu_num(rs.getString("num"));
				stu.setStu_grade(rs.getString("grade"));
				stu.setStu_code(rs.getString("calss"));
				stu.setStu_name(rs.getString("name"));
				stu.setSubject_sum(rs.getInt("sum_1"));
				stu.setHakjum_sum(rs.getInt("sum_2"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch (Exception s){s.printStackTrace();}
		}
				
		return stu;
	}
	
	public void setIn_stu(String code, String tableName){
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("update lecture_"+tableName+" set in_stu=in_stu+1 where l_code=?");
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch (Exception s){s.printStackTrace();}
		}
	}
	
	public List<String> getCode(String grade, String number){
		List<String> list = new ArrayList<String>();
		
		String code = null;
		String sub_code[] = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select code from grade_"+grade+" where num=?");
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				code = rs.getString("code");
			}
		
			if(code != null){
				sub_code = code.split(",");
				
				for(int i=0; i<sub_code.length; i++){
					String value[] = sub_code[i].split("=");
					list.add(value[0]);
				}
			}
		
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch (Exception s){s.printStackTrace();}
		}
		
		return list;
	}
}

