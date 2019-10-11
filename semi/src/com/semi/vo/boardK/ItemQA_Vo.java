package com.semi.vo.boardK;

public class ItemQA_Vo {
	private int qnum;
	private int inum;
	private String writer;
	private String title;
	private String content;
	private String answer;
	public ItemQA_Vo() {}
	public ItemQA_Vo(int qnum, int inum, String writer, String title, String content, String answer) {
		this.qnum = qnum;
		this.inum = inum;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.answer = answer;
	}
	public int getQnum() {
		return qnum;
	}
	public void setQnum(int qnum) {
		this.qnum = qnum;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
