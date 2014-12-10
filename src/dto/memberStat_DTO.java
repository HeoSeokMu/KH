package dto;

import java.sql.Timestamp;

public class memberStat_DTO {
	private String type;			// 회원 유형. 학생인가 교수인가 교직원인가.
	private String id;				// 학번, 교수번호, 교직원 번호
	private int grade;				// 학년, 근무년수(교수, 교직원)
	private String name;			// 이름
	private String stat;			// 현재 상태
	private Timestamp start_date;	// 입학년도, 근무 시작 일자
	private Timestamp end_date;		// 졸업년도, 근무 마지막 일자
	private int restcount;			// 휴학횟수
	
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
