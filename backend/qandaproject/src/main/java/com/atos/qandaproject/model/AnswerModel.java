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
@Table(name = "answer")
public class AnswerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "questionid")
	private QuestionModel questionid;

	public AnswerModel() {
		super();
	}

	public AnswerModel(int id, String answer, String name, QuestionModel questionid) {
		super();
		this.id = id;
		this.answer = answer;
		this.name = name;
		this.questionid = questionid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionModel getQuestionid() {
		return questionid;
	}

	public void setQuestionid(QuestionModel questionid) {
		this.questionid = questionid;
	}

	
	
                         

}
