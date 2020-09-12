package kr.co.devst.model;

import java.util.Date;

public class UserVO {
	private int memId;
	private String memEmail;
	private String memPassword;
	private String memUsername;
	private String memNickname;
	private String memGrade;
	private Date memSingupDate;
	private Date memSigninDate;
	private String memProfileImage;
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemUsername() {
		return memUsername;
	}
	public void setMemUsername(String memUsername) {
		this.memUsername = memUsername;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}
	public Date getMemSingupDate() {
		return memSingupDate;
	}
	public void setMemSingupDate(Date memSingupDate) {
		this.memSingupDate = memSingupDate;
	}
	public Date getMemSigninDate() {
		return memSigninDate;
	}
	public void setMemSigninDate(Date memSigninDate) {
		this.memSigninDate = memSigninDate;
	}
	public String getMemProfileImage() {
		return memProfileImage;
	}
	public void setMemProfileImage(String memProfileImage) {
		this.memProfileImage = memProfileImage;
	}
	@Override
	public String toString() {
		return "UserVO [memId=" + memId + ", memEmail=" + memEmail + ", memPassword=" + memPassword + ", memUsername="
				+ memUsername + ", memNickname=" + memNickname + ", memGrade=" + memGrade + ", memSingupDate="
				+ memSingupDate + ", memSigninDate=" + memSigninDate + ", memProfileImage=" + memProfileImage + "]";
	}
}
