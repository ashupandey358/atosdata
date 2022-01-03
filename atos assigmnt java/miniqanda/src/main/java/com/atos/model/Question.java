package com.atos.model;

public class Question {

	private int id;
	private String question;
	private String detailedQuestion;
	private int userid;
	public Question() {
		super();
	}
	public Question(int id, String question, String detailedQuestion, int userid) {
		super();
		this.id = id;
		this.question = question;
		this.detailedQuestion = detailedQuestion;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getDetailedQuestion() {
		return detailedQuestion;
	}
	public void setDetailedQuestion(String detailedQuestion) {
		this.detailedQuestion = detailedQuestion;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", detailedQuestion=" + detailedQuestion + ", userid="
				+ userid + "]";
	}
	
	
}
