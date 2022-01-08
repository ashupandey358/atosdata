package com.atos.model;

public class Question {

	private int id;
	private String question;
	private String detailedQuestion;
	private String dateTime;
	private int userId;
	public Question() {
		super();
	}
	public Question(int id, String question, String dateTime) {
		super();
		this.id = id;
		this.question = question;
		this.dateTime = dateTime;
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
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", detailedQuestion=" + detailedQuestion
				+ ", dateTime=" + dateTime + ", userId=" + userId + "]";
	}
	
	

	




	
	
	
	
	
}
