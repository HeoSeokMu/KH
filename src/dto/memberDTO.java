package dto;

import java.sql.Timestamp;

public class memberDTO {
	
	private String type;//회원 유형. 학생인가 교수인가 교직원인가.
	private String num1;//등록년도
	private String num2;//학과 또는 업무부서
	//학생의 경우. 001.영어영문학과 002.국어국문학과 003.경제경역학과 004.컴퓨터공학과 005.정보보안학과
	//교수의 경우. 401.영어영문학과 402.국어국문학과 403.경제경역학과 404.컴퓨터공학과 405.정보보안학과
	//교직원의 경우. 801.재정과 802.총무과 803.인사과
	private int num3;//자동증가 번호
	private String id;//num123 을 합친 통합 학번 및 교번
	private String password;//비밀번호
	private String name;//이름
	private String sex;//성별
	private String email;//이메일
	private String s_phone;//학생 연락처
	private String p_phone;//보호자 연락처
	private Timestamp reg_date;//등록일자
	private String birth_yy;//생년
	private String birth_mm;//생월
	private String birth_dd;//생일
	private String pro_img;//프로필 사진
	private String addr;//주소
	private String post;//우편번호
	private String major;//전공
	private String enter_way;//입학구분. 학생의 경우. 정시입학인가 수시입학인가 편입학인가.
	//교수의 경우. 정교수인가 시간강사인가.
	private String before_school;//출신고등학교
	
	private int grade;				// 학년, 근무년수(교수, 교직원)
	private String status;			// 현재 상태
	private int rest_count;			// 휴학횟수
	private Timestamp end_date;		// 졸업년도, 근무 마지막 일자
	private int semester;			// 학기
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRest_count() {
		return rest_count;
	}
	public void setRest_count(int rest_count) {
		this.rest_count = rest_count;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getType() {
		return type;
	}
	public String getNum1() {
		return num1;
	}
	public String getNum2() {
		return num2;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getEmail() {
		return email;
	}
	public String getS_phone() {
		return s_phone;
	}
	public String getP_phone() {
		return p_phone;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public String getBirth_yy() {
		return birth_yy;
	}
	public String getBirth_mm() {
		return birth_mm;
	}
	public String getBirth_dd() {
		return birth_dd;
	}
	public String getPro_img() {
		return pro_img;
	}
	public String getAddr() {
		return addr;
	}
	public String getPost() {
		return post;
	}
	public String getMajor() {
		return major;
	}
	public String getEnter_way() {
		return enter_way;
	}
	public String getBefore_school() {
		return before_school;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public void setBirth_yy(String birth_yy) {
		this.birth_yy = birth_yy;
	}
	public void setBirth_mm(String birth_mm) {
		this.birth_mm = birth_mm;
	}
	public void setBirth_dd(String birth_dd) {
		this.birth_dd = birth_dd;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setEnter_way(String enter_way) {
		this.enter_way = enter_way;
	}
	public void setBefore_school(String before_school) {
		this.before_school = before_school;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}