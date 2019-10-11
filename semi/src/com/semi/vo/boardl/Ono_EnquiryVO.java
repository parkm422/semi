package com.semi.vo.boardl;

public class Ono_EnquiryVO {
	private int ennum;
	private String category;
	private String writer;
	private String title;
	private String content;
	private String answer;
	
	public Ono_EnquiryVO() {}

	public Ono_EnquiryVO(int ennum, String category, String writer, String title, String content, String answer) {
		super();
		this.ennum = ennum;
		this.category = category;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.answer = answer;
	}

	public int getEnnum() {
		return ennum;
	}

	public void setEnnum(int ennum) {
		this.ennum = ennum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

	
	
}
