package dto;

import java.sql.Timestamp;

public class libraryDTO {

	private int book_id;			//å��� ��ȣ
	private String book_title;		//å ����
	private String book_location;	//å ��ġ
	private String book_writer;		//����
	private String book_publisher;	//����
	private int book_year;			//������
	private String book_supplement;	//�η�
	private String file_orgname;	//å �̹��� 
	private String file_savname;	//å �̹���
	private Timestamp insert_year;		//��� ��
	private String book_lent;		//å ����ǥ��
	private int lent_year;			//���� ��
	private int return_year;		//�ݳ� ��
	private int isbn;			//isbn
	private int lent;			//����.
	
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
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
	public String getFile_orgname() {
		return file_orgname;
	}
	public void setFile_orgname(String file_orgname) {
		this.file_orgname = file_orgname;
	}
	public String getFile_savname() {
		return file_savname;
	}
	public void setFile_savname(String file_savname) {
		this.file_savname = file_savname;
	}

	public Timestamp getInsert_year() {
		return insert_year;
	}
	public void setInsert_year(Timestamp insert_year) {
		this.insert_year = insert_year;
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
	public int getLent() {
		return lent;
	}
	public void setLent(int lent) {
		this.lent = lent;
	}
	
	
	
}
