package dto;

import java.sql.Timestamp;

public class noticeboard_DTO {
	private int num;//시퀀스 넘버
	private String title;//공지사항 제목
	private String content;//공지사항 내용
	private String writer;//공지사항 글쓴이
	private Timestamp reg_date;//공지사항 등록일자
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
