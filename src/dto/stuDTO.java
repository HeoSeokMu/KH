package dto;

public class stuDTO {
	String stu_num;
	String stu_code;
	String stu_grade;
	String stu_name;
	int subject_sum;
	int hakjum_sum;
	String allcode;
	
	int year;
	int semester;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}
	public String getAllcode() {
		return allcode;
	}
	public void setAllcode(String allcode) {
		this.allcode = allcode;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_code() {
		return stu_code;
	}
	public void setStu_code(String stu_code) {
		this.stu_code = stu_code;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getSubject_sum() {
		return subject_sum;
	}
	public void setSubject_sum(int subject_sum) {
		this.subject_sum = subject_sum;
	}
	public int getHakjum_sum() {
		return hakjum_sum;
	}
	public void setHakjum_sum(int hakjum_sum) {
		this.hakjum_sum = hakjum_sum;
	}	
}
