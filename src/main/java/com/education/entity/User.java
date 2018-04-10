package com.education.entity;

public class User{
	
	private Integer id;//用户名id
	private String userName;//用户名
	private String schoolName; //学校名称
	private String subject;//科目
	private String gradeClass;//班级
	private String password;//密码
	private String email;//邮箱
	private String mobile;//手机号
	private int status;//状态
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", schoolName="
				+ schoolName + ", subject=" + subject + ", gradeClass="
				+ gradeClass + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", status=" + status + "]";
	}

	public User(Integer id, String userName, String schoolName, String subject,
			String gradeClass, String password, String email, String mobile,
			int status) {
		super();
		this.id = id;
		this.userName = userName;
		this.schoolName = schoolName;
		this.subject = subject;
		this.gradeClass = gradeClass;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGradeClass() {
		return gradeClass;
	}
	public void setGradeClass(String gradeClass) {
		this.gradeClass = gradeClass;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
