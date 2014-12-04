package dto;

import java.sql.Timestamp;

public class rentDTO {
	private String s_num;
	private String b_num;
	private Timestamp turnin;
	private int extension;
	
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
	public Timestamp getTurnin() {
		return turnin;
	}
	public void setTurnin(Timestamp turnin) {
		this.turnin = turnin;
	}
	public int getExtension() {
		return extension;
	}
	public void setExtension(int extension) {
		this.extension = extension;
	}
	
}
