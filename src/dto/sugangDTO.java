package dto;

public class sugangDTO {
	String m_code;	//학과
	String l_type;	//구분(전선,전필....)
	String l_code;	//강의 코드번호
	String l_name;	//강의명(과목)
	String professor;	//교수 이름
	int p_code;	//교수 번호
	String l_room;	//강의실
	int y_grade;	//학년
	int f_grade;	//이수학점
	int semester;	//학기
	int l_start; 	//강의 시작시간
	int l_end;	//강의 시간
	String l_day;	//강의일
	int in_stu;	 	//신청 된 수강인원
	int limit_stu;	// 수강 가능한 인원 
	String s_date;	//개강
	String l_date; //종강
	
	int count;
	int day;
	int num;
	String time_day;
	
	
	public int getP_code() {
		return p_code;
	}
	public void setP_code(int p_code) {
		this.p_code = p_code;
	}
	public String getTime_day() {
		return time_day;
	}
	public void setTime_day(String time_day) {
		this.time_day = time_day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getL_type() {
		return l_type;
	}
	public void setL_type(String l_type) {
		this.l_type = l_type;
	}
	public String getL_code() {
		return l_code;
	}
	public void setL_code(String l_code) {
		this.l_code = l_code;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getL_room() {
		return l_room;
	}
	public void setL_room(String l_room) {
		this.l_room = l_room;
	}
	public int getY_grade() {
		return y_grade;
	}
	public void setY_grade(int y_grade) {
		this.y_grade = y_grade;
	}
	public int getF_grade() {
		return f_grade;
	}
	public void setF_grade(int f_grade) {
		this.f_grade = f_grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getL_start() {
		return l_start;
	}
	public void setL_start(int l_start) {
		this.l_start = l_start;
	}
	public int getL_end() {
		return l_end;
	}
	public void setL_end(int l_end) {
		this.l_end = l_end;
	}
	public String getL_day() {
		return l_day;
	}
	public void setL_day(String l_day) {
		this.l_day = l_day;
	}
	public int getIn_stu() {
		return in_stu;
	}
	public void setIn_stu(int in_stu) {
		this.in_stu = in_stu;
	}
	public int getLimit_stu() {
		return limit_stu;
	}
	public void setLimit_stu(int limit_stu) {
		this.limit_stu = limit_stu;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getL_date() {
		return l_date;
	}
	public void setL_date(String l_date) {
		this.l_date = l_date;
	}	
}
