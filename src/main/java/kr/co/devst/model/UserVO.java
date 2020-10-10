package kr.co.devst.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial") 
public class UserVO implements UserDetails {
	private int memId;
	private String memEmail;
	private String memPassword;
	private String memNickname;
	private String memGrade;
	private Date memSingupDate;
	private Date memSigninDate;
	private String memProfileImage;
	private String memAuthority;
	private boolean memEnabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(memAuthority));
		return auth;
	}
	@Override
	public String getPassword() {
		return memPassword;
	}
	@Override
	public String getUsername() {
		return memEmail;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return memEnabled;
	}
	
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
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
		return "UserVO [memId=" + memId + ", memEmail=" + memEmail + ", memPassword=" + memPassword 
				+ ", memNickname=" + memNickname + ", memGrade=" + memGrade + ", memSingupDate="
				+ memSingupDate + ", memSigninDate=" + memSigninDate + ", memProfileImage=" + memProfileImage
				+ ", memAuthority=" + memAuthority + ", memEnabled=" + memEnabled + "]";
	}
	
}
