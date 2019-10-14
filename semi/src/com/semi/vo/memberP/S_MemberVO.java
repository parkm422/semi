package com.semi.vo.memberP;

import java.sql.Date;


public class S_MemberVO {

	private int mnum;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String address;
	private String phone;
	private int point;
	private Date joindate;
	
	public S_MemberVO() {
		
	}

	public S_MemberVO(int mnum,String name, String id, String pwd, String email, String address, String phone, int point,
			Date joindate) {
		super();
		this.mnum = mnum;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.point = point;
		this.joindate = joindate;
	}

	public int getMnum() {
		return mnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
}
