package com.semi.vo.product;

public class ColorVO {
	
	private String cnum;
	private String sizenum;
	private String colorname;
	
	public ColorVO() {
		
	}

	public ColorVO(String cnum, String sizenum, String colorname) {
		super();
		this.cnum = cnum;
		this.sizenum = sizenum;
		this.colorname = colorname;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getSizenum() {
		return sizenum;
	}

	public void setSizenum(String sizenum) {
		this.sizenum = sizenum;
	}

	public String getColorname() {
		return colorname;
	}

	public void setColorname(String colorname) {
		this.colorname = colorname;
	}
	
}
