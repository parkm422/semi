package com.semi.vo.managerP;

public class ViewVo {
	private String name;
	private String id;
	private String pname;
	private int psize;
	private String color;
	private int cnt;
	private int price;
	private String status;
	private String delivery;
	
	private int dnum;
	private int ornum;
	private int inum;
	private String ppname;
	private int ppsize;
	private String ccolor;
	private int ccnt;
	

	public ViewVo() {}

	public ViewVo(String name, String id, String pname, int psize, String color, int cnt, int price, String status,
			String delivery) {
		super();
		this.name = name;
		this.id = id;
		this.pname = pname;
		this.psize = psize;
		this.color = color;
		this.cnt = cnt;
		this.price = price;
		this.status = status;
		this.delivery = delivery;
	}
	
	public ViewVo(int dnum, int ornum,int inum,String ppname,int ppsize,String ccolor,int ccnt) {
		super();
		this.dnum = dnum;
		this.ornum = ornum;
		this.inum = inum;
		this.ppname = ppname;
		this.ppsize = ppsize;
		this.ccolor = ccolor;
		this.ccnt = ccnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPirce(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
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

	public String getPpname() {
		return ppname;
	}

	public void setPpname(String ppname) {
		this.ppname = ppname;
	}

	public int getPpsize() {
		return ppsize;
	}

	public void setPpsize(int ppsize) {
		this.ppsize = ppsize;
	}

	public String getCcolor() {
		return ccolor;
	}

	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}

	public int getCcnt() {
		return ccnt;
	}

	public void setCcnt(int ccnt) {
		this.ccnt = ccnt;
	}

	
}
