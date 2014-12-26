package dto;

import java.sql.Timestamp;

public class reserveDTO {
	private String s_num;
	private String b_num;
	private String book_img;
	private String email;
	private Timestamp rent;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRent() {
		return rent;
	}
	public void setRent(Timestamp rent) {
		this.rent = rent;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	
}
