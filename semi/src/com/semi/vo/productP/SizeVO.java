package com.semi.vo.productP;

public class SizeVO {
	
	private String sizenum;
	private String scnum;
	private int psize;
	
	public SizeVO() {
		
	}

	public SizeVO(String sizenum, String scnum, int psize) {
		super();
		this.sizenum = sizenum;
		this.scnum = scnum;
		this.psize = psize;
	}

	public String getSizenum() {
		return sizenum;
	}

	public void setSizenum(String sizenum) {
		this.sizenum = sizenum;
	}

	public String getScnum() {
		return scnum;
	}

	public void setScnum(String scnum) {
		this.scnum = scnum;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}
	
}
