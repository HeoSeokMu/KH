package dto;

import java.util.Date;

public class reserveDTO {
	private String s_num;
	private String b_num;
	private Date rent;
	
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getB_num() {
		return b_num;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public Date getRent() {
		return rent;
	}
	public void setRent(Date rent) {
		this.rent = rent;
	}
	
}
