package dto;

import java.sql.Timestamp;


public class vacationDTO {
	private int no;//������ �ѹ�
	private String name;//�ް� ��û��
	private String type;//�ް� ��û�� ����
	private String major;//�ް� ��û�� �Ҽ�
	private String vacStart_yy;//�ް� ���� ����
	private String vacStart_mm;//�ް� ���� ��
	private String vacStart_dd;//�ް� ���� ��
	private String vacEnd_yy;//�ް� �� ����
	private String vacEnd_mm;//�ް� �� ��
	private String vacEnd_dd;//�ް� �� ��
	private String vacation_reason;//�ް� ����
	private Timestamp reg_date;//��� ���� �� ���� ����
	private String result;//ó�� ����
	private String id;
	
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
	public String getVacStart_yy() {
		return vacStart_yy;
	}
	public String getVacStart_mm() {
		return vacStart_mm;
	}
	public String getVacStart_dd() {
		return vacStart_dd;
	}
	public String getVacEnd_yy() {
		return vacEnd_yy;
	}
	public String getVacEnd_mm() {
		return vacEnd_mm;
	}
	public String getVacEnd_dd() {
		return vacEnd_dd;
	}
	public void setVacStart_yy(String vacStart_yy) {
		this.vacStart_yy = vacStart_yy;
	}
	public void setVacStart_mm(String vacStart_mm) {
		this.vacStart_mm = vacStart_mm;
	}
	public void setVacStart_dd(String vacStart_dd) {
		this.vacStart_dd = vacStart_dd;
	}
	public void setVacEnd_yy(String vacEnd_yy) {
		this.vacEnd_yy = vacEnd_yy;
	}
	public void setVacEnd_mm(String vacEnd_mm) {
		this.vacEnd_mm = vacEnd_mm;
	}
	public void setVacEnd_dd(String vacEnd_dd) {
		this.vacEnd_dd = vacEnd_dd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
