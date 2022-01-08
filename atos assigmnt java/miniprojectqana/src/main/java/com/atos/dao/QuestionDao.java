package com.atos.dao;

import java.util.ArrayList;

import com.atos.exception.AppException;
import com.atos.model.Question;

public interface QuestionDao {
	
	public void postQuestion(Question question) throws AppException;
	
	public ArrayList<Question> getQuestion() throws AppException;
	
	public ArrayList<Question> myQuestion(int userId) throws AppException;

}
