package com.semi.vo.productP;

public class Product_ListVO {
	
	private int inum;
	private String cnum;
	private String pname;
	private int price;
	private int cnt;
	private int salecnt;
	
	public Product_ListVO() {
		
	}

	public Product_ListVO(int inum, String cnum, String pname, int price, int cnt, int salecnt) {
		super();
		this.inum = inum;
		this.cnum = cnum;
		this.pname = pname;
		this.price = price;
		this.cnt = cnt;
		this.salecnt = salecnt;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getSalecnt() {
		return salecnt;
	}

	public void setSalecnt(int salecnt) {
		this.salecnt = salecnt;
	}
	
	
}
