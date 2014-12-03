package dto;

import java.sql.Timestamp;

public class memberDTO {
	
	private String type;//회원유형. 학생인가 교수인가 교직원인가
	private String num1;//등록년도
	private String num2;//학과 및 직원 업무처 구분
	private int num3;//자동증가번호
	private String s_num;//학번, 교번, 교직원번호 통합. 아이디로도 사용.
	private String password;//비밀번호
	private String name;//이름
	private String sex;//성별
	private String e_mail;//이메일
	private String s_phone;//본인 연락처
	private String p_phone;//보호자 연락처
	private Timestamp reg_date;//등록일자
	private String birth_yy;//생년
	private String birth_mm;//생월
	private String birth_dd;//생일
	private String pro_img;//프로필 사진
	private String address;//주소
	private String post;//우편번호
	private String major;//전공
	private String enter_way;//정시입학인가 수시입학인가 편입학인가
	private String before_school;//출신학교
	
	
	public String getType() {
		return type;
	}
	public String getNum1() {
		return num1;
	}
	public String getNum2() {
		return num2;
	}
	public String getS_num() {
		return s_num;
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
	public String getE_mail() {
		return e_mail;
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
	public String getAddress() {
		return address;
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
	public void setS_num(String s_num) {
		this.s_num = s_num;
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
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
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
	public void setAddress(String address) {
		this.address = address;
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
<<<<<<< HEAD
	
}
=======
}
>>>>>>> edf3ac8aa580472aaecc3a4ef6b8f20e5dbb6564
