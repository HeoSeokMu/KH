package dto;

import java.sql.Timestamp;

public class memberDTO {
	
	private String type;//ȸ�� ����. �л��ΰ� �����ΰ� �������ΰ�.
	private String num1;//��ϳ⵵
	private String num2;//�а� �Ǵ� �����μ�
	//�л��� ���. 001.������а� 002.������а� 003.�����濪�а� 004.��ǻ�Ͱ��а� 005.���������а�
	//������ ���. 401.������а� 402.������а� 403.�����濪�а� 404.��ǻ�Ͱ��а� 405.���������а�
	//�������� ���. 801.������ 802.�ѹ��� 803.�λ��
	private int num3;//�ڵ����� ��ȣ
	private String id;//num123 �� ��ģ ���� �й� �� ����
	private String password;//��й�ȣ
	private String name;//�̸�
	private String sex;//����
	private String email;//�̸���
	private String s_phone;//���� ����ó
	
	private Timestamp reg_date;//�������
	private String birth_yy;//����
	private String birth_mm;//����
	private String birth_dd;//����
	private String pro_img;//������ ����
	private String addr;//�ּ�
	private String post;//�����ȣ
	private String major;//����
	private String enter_way;//���б���. �л��� ���. ���������ΰ� ���������ΰ� �������ΰ�.
	//������ ���. �������ΰ� �ð������ΰ�.
	private String before_school;//��Ű���б�
	
	private int grade;				// �г�, �ٹ����(����, ������)
	private String status;			// ���� ����
	private int rest_count;			// ����Ƚ��
	private Timestamp end_date;		// �����⵵, �ٹ� ������ ����
	private int semester;			// �б�
	
	//��ȣ�� ���� �κ�
	private String parent_name;	//��ȣ�� ����
	private String p_phone;	//��ȣ�� ����ó
	private String parent_job;	//��ȣ�� ����
	private String p_addr;	//��ȣ�� �ּ�
	private String p_post;	//��ȣ�� �����ȣ
	
	//���� ���� ����, ���� �̼����� ����.
	private String major_kind;	//���� ���� ����
	private int finish_point;	//�����̼� ����
	
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
	public String getParent_name() {
		return parent_name;
	}
	public String getParent_job() {
		return parent_job;
	}
	public String getP_addr() {
		return p_addr;
	}
	public String getP_post() {
		return p_post;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public void setParent_job(String parent_job) {
		this.parent_job = parent_job;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	public void setP_post(String p_post) {
		this.p_post = p_post;
	}
	public String getMajor_kind() {
		return major_kind;
	}
	public int getFinish_point() {
		return finish_point;
	}
	public void setMajor_kind(String major_kind) {
		this.major_kind = major_kind;
	}
	public void setFinish_point(int finish_point) {
		this.finish_point = finish_point;
	}
	
}