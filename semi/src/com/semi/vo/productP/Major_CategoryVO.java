package com.semi.vo.productP;

public class Major_CategoryVO {
	
	private int mcnum;
	private String m_category;
	
	public Major_CategoryVO() {
		
	}

	public Major_CategoryVO(int mcnum, String m_category) {
		super();
		this.mcnum = mcnum;
		this.m_category = m_category;
	}

	public int getMcnum() {
		return mcnum;
	}

	public void setMcnum(int mcnum) {
		this.mcnum = mcnum;
	}

	public String getM_category() {
		return m_category;
	}

	public void setM_category(String m_category) {
		this.m_category = m_category;
	}
	
	
	
}
