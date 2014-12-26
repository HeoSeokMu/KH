package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.hakjumDTO;

public class hakjumDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static hakjumDAO instance = new hakjumDAO();
		
	public static hakjumDAO getInstance() {
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
	
	public List getList(int p_code){
		hakjumDTO dto = null;
		
		List<hakjumDTO> list = new ArrayList<hakjumDTO>();
		
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from hakjum_2014_1 where p_code=?");
			pstmt.setInt(1,p_code);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new hakjumDTO();
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setCode(rs.getString("code"));	
				dto.setName(rs.getString("name"));	
				dto.setProfessor(rs.getString("professor"));	
				dto.setP_code(rs.getInt("p_code"));	
				dto.setS_grade(rs.getInt("s_grade"));	
				dto.setS_name(rs.getString("s_name"));	
				dto.setS_code(rs.getString("s_code"));	
				dto.setF_grade(rs.getInt("f_grade"));	
				dto.setResultA(rs.getInt("resultA"));	
				dto.setResultB(rs.getString("resultB"));
				dto.setChk(rs.getInt("chk"));
			
				list.add(dto);
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
				pstmt.close();
			}catch(Exception s){s.printStackTrace();}
		}
				
		return list;
	}
}
