package com.semi.vo.boardP;

public class ReviewVO {
	
	private int rnum;
	private int inum;
	private String writer;
	private String title;
	private String content;
	private String orgfilename;
	private String savefilename;
	private int rating;
	
	public ReviewVO() {
		
	}

	public ReviewVO(int rnum, int inum, String writer, String title, String content, String orgfilename,
			String savefilename, int rating) {
		super();
		this.rnum = rnum;
		this.inum = inum;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.orgfilename = orgfilename;
		this.savefilename = savefilename;
		this.rating = rating;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
