package kr.co.devst.model;

import java.util.Date;

public class UserVO {
	private int mem_id;
	private String mem_email;
	private String mem_password;
	private String mem_username;
	private String mem_nickname;
	private String mem_grade;
	private Date mem_singup_date;
	private Date mem_signin_date;
	private String mem_profile_image;
	
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public String getMem_username() {
		return mem_username;
	}
	public void setMem_username(String mem_username) {
		this.mem_username = mem_username;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	public Date getMem_singup_date() {
		return mem_singup_date;
	}
	public void setMem_singup_date(Date mem_singup_date) {
		this.mem_singup_date = mem_singup_date;
	}
	public Date getMem_signin_date() {
		return mem_signin_date;
	}
	public void setMem_signin_date(Date mem_signin_date) {
		this.mem_signin_date = mem_signin_date;
	}
	public String getMem_profile_image() {
		return mem_profile_image;
	}
	public void setMem_profile_image(String mem_profile_image) {
		this.mem_profile_image = mem_profile_image;
	}
	@Override
	public String toString() {
		return "UserVO [mem_id=" + mem_id + ", mem_email=" + mem_email + ", mem_password=" + mem_password
				+ ", mem_username=" + mem_username + ", mem_nickname=" + mem_nickname + ", mem_grade=" + mem_grade
				+ ", mem_singup_date=" + mem_singup_date + ", mem_signin_date=" + mem_signin_date
				+ ", mem_profile_image=" + mem_profile_image + "]";
	}
	

	
}
