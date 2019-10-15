package com.semi.vo.productP;

public class Product_ImgVO {
	
	private int imgnum;
	private int inum;
	private String orgfilename;
	private String savefilename;
	
	public Product_ImgVO() {
		
	}

	public Product_ImgVO(int imgnum, int inum, String orgfilename, String savefilename) {
		super();
		this.imgnum = imgnum;
		this.inum = inum;
		this.orgfilename = orgfilename;
		this.savefilename = savefilename;
	}

	public int getImgnum() {
		return imgnum;
	}

	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getSavefilename() {
		return savefilename;
	}

	public void setSavefilename(String savefilename) {
		this.savefilename = savefilename;
	}
	
}
