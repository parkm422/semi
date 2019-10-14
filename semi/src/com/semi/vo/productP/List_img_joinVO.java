package com.semi.vo.productP;

public class List_img_joinVO {
	
	private int inum;
	private String pname;
	private int price;
	private int cnt;
	private String cnum;
	private int salecnt;
	private int imgnum;
	private String savefilename;
	
	public List_img_joinVO() {
		
	}

	public List_img_joinVO(int inum, String pname, int price, int cnt, String cnum, int salecnt, int imgnum,
			String savefilename) {
		super();
		this.inum = inum;
		this.pname = pname;
		this.price = price;
		this.cnt = cnt;
		this.cnum = cnum;
		this.salecnt = salecnt;
		this.imgnum = imgnum;
		this.savefilename = savefilename;
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

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public int getSalecnt() {
		return salecnt;
	}

	public void setSalecnt(int salecnt) {
		this.salecnt = salecnt;
	}

	public int getImgnum() {
		return imgnum;
	}

	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}

	public String getSavefilename() {
		return savefilename;
	}

	public void setSavefilename(String savefilename) {
		this.savefilename = savefilename;
	}
	
}
