package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dto.memberDTO;
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
				dto.setNum(rs.getInt("num"));
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
		int count = 0;
		String table = stu.getYear()+"_"+stu.getSemester();
		try{	
			conn = getConnection();		
			pstmt = conn.prepareStatement("select count(*) from grade_"+table+" where num=?");
			pstmt.setInt(1, Integer.parseInt(stu.getStu_num()));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); 
			}
			
			if(count > 0 ){
				pstmt = conn.prepareStatement("delete from grade_"+table+" where num=?");
				pstmt.setInt(1, Integer.parseInt(stu.getStu_num()));
				pstmt.executeUpdate();
			}
			
			pstmt = conn.prepareStatement("insert into grade_"+table+" values (?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,stu.getStu_num());
			pstmt.setString(2,stu.getStu_code());
			pstmt.setString(3,stu.getStu_grade());
			pstmt.setString(4,stu.getStu_name() );
			pstmt.setInt(5,stu.getSubject_sum());
			pstmt.setInt(6,stu.getHakjum_sum() );
			pstmt.setString(7,stu.getAllcode());
			pstmt.setInt(8,stu.getYear());
			pstmt.setInt(9,stu.getSemester());
			
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
	
	public List<sugangDTO> getSugangList(String number, String semester){
		List<sugangDTO> list = new ArrayList<sugangDTO>();
		sugangDTO dto = null;
		String table = "2014_"+semester;
		int countList = 0;
		
		String code = null;
		String sub_code[] = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select code from grade_"+table+" where num=?");
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
					dto.setNum(rs.getInt("num"));
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
	
	public stuDTO getstu(String semester, String number){
		stuDTO stu = new stuDTO();
		
		semester = "2014_"+semester;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from grade_"+semester+" where num=?");
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
	
	public void setIn_stu_pl(String code, String tableName){
		
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
	
	public void setIn_stu_mi(String code, String tableName){
		
		int in = 0;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("update lecture_"+tableName+" set in_stu=in_stu-1 where l_code=?");
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select in_stu from lecture_"+tableName+"  where l_code=?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				in = rs.getInt("in_stu");
			}
		
			if(in < 0){
				pstmt = conn.prepareStatement("update lecture_"+tableName+" set in_stu=0 where l_code=?");
				pstmt.setString(1, code);
				pstmt.executeUpdate();
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
	}
	
	public List<String> getCode(String semester, String number){
		List<String> list = new ArrayList<String>();
		
		String code = null;
		String sub_code[] = null;
		semester = "2014_"+semester;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select code from grade_"+semester+" where num=?");
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
	
	public void setStu_hakjum(List <sugangDTO>list, memberDTO member){
		int result = 0;
		int code = 2014401001;
/*		
  		seq num
		1 구분(전선,전필....)
		2 강의 코드번호
		3 강의명(과목)
		4 교수
		5 교수번호
		6 학년
		7 이름
		8 학번
		9 학점
		10 성적A default
		11 성적B default
		12 학점 인정 여부 default
	*/
		
		try{
			conn = getConnection();
			
		for(int i=0; i<list.size(); i++){
			pstmt = conn.prepareStatement("insert into hakjum_2014_1 values (hakjum_2014_1_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,default,default,default)");
			pstmt.setString(1,list.get(i).getL_type());
			pstmt.setString(2,list.get(i).getL_code());
			pstmt.setString(3,list.get(i).getL_name());
			pstmt.setString(4,list.get(i).getProfessor());
//			pstmt.setInt(5,list.get(i).getP_code());
			pstmt.setInt(5,code);
			pstmt.setInt(6,member.getGrade());
			pstmt.setString(7,member.getName());
			pstmt.setString(8,member.getId());
			pstmt.setInt(9,list.get(i).getF_grade());

			pstmt.executeUpdate();
		}
					
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch (Exception s){s.printStackTrace();}
			
		}	
	}
}

