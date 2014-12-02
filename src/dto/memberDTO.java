package dto;

import java.sql.Timestamp;

public class memberDTO {
	
	private String type;
	private String num;
	private String password;
	private String name;
	private String sex;
	private String e_mail;
	private String s_phone;
	private String p_phone;
	private Timestamp reg_date;
	private String birth_yy;
	private String birth_mm;
	private String birth_dd;
	private String pro_img;
	private String address;
	private String post;
	private String major;
	private String enter_way;
	private String before_school;
	
	
	public String getType() {
		return type;
	}
	public String getNum() {
		return num;
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
	public void setNum(String num) {
		this.num = num;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}