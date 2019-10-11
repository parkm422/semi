package com.semi.vo.product;

import java.sql.Date;

public class BasketVO {

	private int bnum;
	private int mnum;
	private int inum;
	private String pname;
	private int cnt;
	private Date regdate;
	
	public BasketVO() {
		
	}

	public BasketVO(int bnum, int mnum, int inum, String pname, int cnt, Date regdate) {
		super();
		this.bnum = bnum;
		this.mnum = mnum;
		this.inum = inum;
		this.pname = pname;
		this.cnt = cnt;
		this.regdate = regdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
