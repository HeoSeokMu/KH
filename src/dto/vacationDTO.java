package dto;

import java.sql.Timestamp;

import org.apache.tomcat.util.buf.TimeStamp;

public class vacationDTO {
	private int no;
	private String name;
	private String type;
	private String major;
	private String vacation_start;
	private String vacation_end;
	private String vacation_reason;
	private Timestamp reg_date;
	private String result;
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getMajor() {
		return major;
	}
	public String getVacation_start() {
		return vacation_start;
	}
	public String getVacation_end() {
		return vacation_end;
	}
	public String getVacation_reason() {
		return vacation_reason;
	}
	public String getResult() {
		return result;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setVacation_start(String vacation_start) {
		this.vacation_start = vacation_start;
	}
	public void setVacation_end(String vacation_end) {
		this.vacation_end = vacation_end;
	}
	public void setVacation_reason(String vacation_reason) {
		this.vacation_reason = vacation_reason;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

}
