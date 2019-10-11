package com.semi.vo.productP;

public class OrderDetailVO {
	
	private int dnum;
	private int ornum;
	private int inum;
	private String pname;
	private int psize;
	private String color;
	private int cnt;
	
	public OrderDetailVO() {
		
	}

	public OrderDetailVO(int dnum, int ornum, int inum, String pname, int psize, String color, int cnt) {
		super();
		this.dnum = dnum;
		this.ornum = ornum;
		this.inum = inum;
		this.pname = pname;
		this.psize = psize;
		this.color = color;
		this.cnt = cnt;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	public int getOrnum() {
		return ornum;
	}

	public void setOrnum(int ornum) {
		this.ornum = ornum;
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

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
