package kr.or.ddit.user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserVoJsr303 implements HttpSessionBindingListener {
	
	private int rnum;
	
	@Length(min=5)
	@NotEmpty
	private String  userId ;
	@NotEmpty
	private String  name   ;
	@NotEmpty
	private String  pass   ;
	private String  addr1  ;
	private String  addr2  ;
	private String  zipcd  ;
	
	private String  email  ;
	private String  tel    ;
	private String  profile;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  birth;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "UserVo [rnum=" + rnum + ", userId=" + userId + ", name=" + name
				+ ", pass=" + pass + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", zipcd=" + zipcd + ", birth=" + birth + ", email=" + email
				+ ", tel=" + tel + ", profile=" + profile + "]";
	}
	
	
	/**
	 * Method : authPass
	 * 작성자 : bms
	 * 변경이력 :
	 * @param encryptPass
	 * @return
	 * Method 설명 : 비밀번호 검증
	 */
	public boolean authPass(String encryptPass) {
		
		return getPass().equals(encryptPass);
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("userVo : " + event.getName());
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

	
	
	
}
