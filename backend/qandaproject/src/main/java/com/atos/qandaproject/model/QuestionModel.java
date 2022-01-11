package com.atos.qandaproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class QuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "questions")
	private String questions;
	
	@Column(name = "detailedquestion")
	private String detailedquestion;
	
	@Column(name = "datetime")
	private String datetime;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserModel user;



	public QuestionModel(int id, String questions, String detailedquestion, String datetime, UserModel user) {
		super();
		this.id = id;
		this.questions = questions;
		this.detailedquestion = detailedquestion;
		this.datetime = datetime;
		this.user = user;
	}

	
	public QuestionModel() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getDetailedquestion() {
		return detailedquestion;
	}

	public void setDetailedquestion(String detailedquestion) {
		this.detailedquestion = detailedquestion;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "QuestionModel [id=" + id + ", questions=" + questions + ", detailedquestion=" + detailedquestion
				+ ", datetime=" + datetime + ", user=" + user + "]";
	}

	
	
	
	
	
	
}