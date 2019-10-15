package com.semi.vo.basketY;

import java.sql.Date;

public class BasketVo {
	private int bnum;
	private int mnum;
	private int inum;
	private String pname;
	private int cnt;
	private Date basketdate;
	public BasketVo() {}
	public BasketVo(int bnum,int mnum, int inum, String pname, int cnt,Date basketdate) {
		super();
		this.bnum = bnum;
		this.mnum = mnum;
		this.inum = inum;
		this.pname = pname;
		this.cnt = cnt;
		this.basketdate = basketdate;
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
	public Date getBasketdate() {
		return basketdate;
	}
	public void setBasketdate(Date basketdate) {
		this.basketdate = basketdate;
	}
	
}
