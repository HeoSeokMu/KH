package dto;

import java.sql.Timestamp;

public class memberStat_DTO {
	private String type;			// ȸ�� ����. �л��ΰ� �����ΰ� �������ΰ�.
	private String id;				// �й�, ������ȣ, ������ ��ȣ
	private int grade;				// �г�, �ٹ����(����, ������)
	private String name;			// �̸�
	private String stat;			// ���� ����
	private Timestamp start_date;	// ���г⵵, �ٹ� ���� ����
	private Timestamp end_date;		// �����⵵, �ٹ� ������ ����
	private int restcount;			// ����Ƚ��
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public int getRestcount() {
		return restcount;
	}
	public void setRestcount(int restcount) {
		this.restcount = restcount;
	}
}
