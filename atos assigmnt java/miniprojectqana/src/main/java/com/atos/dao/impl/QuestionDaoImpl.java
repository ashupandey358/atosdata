package com.atos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atos.controller.UserController;
import com.atos.dao.QuestionDao;
import com.atos.dao.Util;
import com.atos.exception.AppException;
import com.atos.model.Question;
import com.atos.model.User;

public class QuestionDaoImpl implements QuestionDao {

	UserController user = new UserController();
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public void postQuestion(Question question) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",question);
		
		try(Connection connection = Util.getConnection())
		{
			String query = "INSERT INTO question (question, detailedQuestion,dateTime,userId) VALUES (? ,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, question.getQuestion());
			statement.setString(2, question.getDetailedQuestion());
			statement.setString(3, question.getDateTime());
			statement.setInt(4,user.getCurrentUser().getId());
			
			statement.executeUpdate();
			LOGGER.debug("Queary excute succesfully");
			LOGGER.info("end");
		} catch (SQLException e) {
			LOGGER.error("error inserting user",e);
			throw new AppException(e);
		}
		
	}

	@Override
	public ArrayList<Question> getQuestion() throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}");
		 ArrayList<Question> questionList = new ArrayList<Question>();
		try (Connection connection = Util.getConnection()){
			String query = "SELECT * FROM question";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Question question= new Question();
				question.setId(result.getInt("id"));
				 question.setQuestion(result.getString("question"));
				 question.setDateTime(result.getString("dateTime"));
				questionList.add(question);
				LOGGER.debug("query excute succesfully");
				LOGGER.info("end");
			}
		} catch (SQLException e) {
			LOGGER.error("error inserting user",e);
			throw new AppException(e);
			
		}
		return questionList;
	}

	@Override
	public ArrayList<Question> myQuestion(int userId) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}");
		 ArrayList<Question> questionList = new ArrayList<Question>();
		try (Connection connection = Util.getConnection()){
			String query = "SELECT * FROM question where userId=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,user.getCurrentUser().getId());
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Question question= new Question();
				question.setId(result.getInt("id"));
				 question.setQuestion(result.getString("question"));
				 question.setDateTime(result.getString("dateTime"));
				 questionList.add(question);
				LOGGER.debug("query excute succesfully");
				LOGGER.info("end");
			}
		} catch (SQLException e) {
			LOGGER.error("error inserting user",e);
			throw new AppException(e);
			
		}
		return questionList;
	}

}
