package com.semi.vo.boardY;

public class BoardVo {
	private int fnum;
	private String category;
	private String question;
	private String answer;
	public BoardVo() {}
	public BoardVo(int fnum, String category, String question, String answer) {
		super();
		this.fnum = fnum;
		this.category = category;
		this.question = question;
		this.answer = answer;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
