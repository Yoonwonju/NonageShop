package nonageshop.dto;

import java.util.Date;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String zipNum;
	private String address;
	private String phone;
	private String leave_yn;
	private Date joinDate;

	@Override
	public String toString() {
		return String.format(
				"Member [id=%s, pwd=%s, name=%s, email=%s, zipNum=%s, address=%s, phone=%s, leave_yn=%s, joinDate=%s]",
				id, pwd, name, email, zipNum, address, phone, leave_yn, joinDate);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipNum() {
		return zipNum;
	}

	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLeave_yn() {
		return leave_yn;
	}

	public void setLeave_yn(String leave_yn) {
		this.leave_yn = leave_yn;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Member(String id, String pwd, String name, String email, String zipNum, String address, String phone,
			String leave_yn, Date joinDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.zipNum = zipNum;
		this.address = address;
		this.phone = phone;
		this.leave_yn = leave_yn;
		this.joinDate = joinDate;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
}
