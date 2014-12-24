package dto;

import java.sql.Timestamp;

public class lectureBoardDTO {
	private int no;
	private String l_name;
	private String professor;
	private String content;
	private Timestamp reg_date;
	private String result;
	
	public int getNo() {
		return no;
	}
	public String getL_name() {
		return l_name;
	}
	public String getProfessor() {
		return professor;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public String getResult() {
		return result;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
