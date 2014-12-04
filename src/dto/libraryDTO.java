package dto;

import java.sql.Date;
import java.sql.Timestamp;

public class libraryDTO {

	private String book_id;			//책등록 번호
	private String book_title;		//책 제목
	private String book_location;	//책 위치
	private String book_writer;		//저자
	private String book_publisher;	//출판
	private int book_year;			//출판일
	private String book_supplement;	//부록
	private int imagename;	//책 이미지 	private Timestamp reg_date;	//등록 일
	private String book_lent;		//책 대출표시
	private int lent_year;			//빌린 일
	private int return_year;		//반납 일
	private int isbn;			//isbn
	private String loan;		// 대출여부
	private String s_num;		// 학번
	private int extension;		// 연장 횟수
	private Date turnin;		// 반납날
	
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_location() {
		return book_location;
	}
	public void setBook_location(String book_location) {
		this.book_location = book_location;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public int getBook_year() {
		return book_year;
	}
	public void setBook_year(int book_year) {
		this.book_year = book_year;
	}
	public String getBook_supplement() {
		return book_supplement;
	}
	public void setBook_supplement(String book_supplement) {
		this.book_supplement = book_supplement;
	}
	

	
	public int getImagename() {
		return imagename;
	}
	public void setImagename(int imagename) {
		this.imagename = imagename;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getBook_lent() {
		return book_lent;
	}
	public void setBook_lent(String book_lent) {
		this.book_lent = book_lent;
	}
	public int getLent_year() {
		return lent_year;
	}
	public void setLent_year(int lent_year) {
		this.lent_year = lent_year;
	}
	public int getReturn_year() {
		return return_year;
	}
	public void setReturn_year(int return_year) {
		this.return_year = return_year;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public int getExtension() {
		return extension;
	}
	public void setExtension(int extension) {
		this.extension = extension;
	}
	public Date getTurnin() {
		return turnin;
	}
	public void setTurnin(Date turnin) {
		this.turnin = turnin;
	}

	
}
