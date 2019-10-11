package com.semi.vo.product;

public class Sub_CategoryVO {
	
	private String scnum;
	private int mcnum;
	private String s_category;
	
	public Sub_CategoryVO() {
		
	}

	public Sub_CategoryVO(String scnum, int mcnum, String s_category) {
		super();
		this.scnum = scnum;
		this.mcnum = mcnum;
		this.s_category = s_category;
	}

	public String getScnum() {
		return scnum;
	}

	public void setScnum(String scnum) {
		this.scnum = scnum;
	}

	public int getMcnum() {
		return mcnum;
	}

	public void setMcnum(int mcnum) {
		this.mcnum = mcnum;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}
	
}
