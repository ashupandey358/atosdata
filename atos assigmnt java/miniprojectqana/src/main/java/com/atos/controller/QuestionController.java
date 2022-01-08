package com.atos.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atos.dao.QuestionDao;
import com.atos.dao.impl.QuestionDaoImpl;
import com.atos.exception.AppException;
import com.atos.model.Question;
import com.atos.model.User;


@Path("/questions")
public class QuestionController {
	
	QuestionDao dao = new QuestionDaoImpl();
	private static Question currentQuestion;
	public static Question getCurrentQuestion() {
		return currentQuestion;
	}
	public static void setCurrentQuestion(Question currentQuestion) {
		QuestionController.currentQuestion = currentQuestion;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response createUser(Question question)
	{
		LOGGER.info("Start");
		LOGGER.debug("{}",question);
		
		try {
			dao.postQuestion(question);
			LOGGER.info("end");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
		
		
	}
	
	@GET

	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion()
	{
		LOGGER.info("Start");
		ArrayList<Question> questions = new ArrayList<>();
		
		try {
			questions = dao.getQuestion();
			LOGGER.info("Get Account details ");
			LOGGER.debug("{}", questions);
			return Response.ok().entity(questions).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
		
	}
  
	@GET
    @Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("userId") int userId)
	{
		LOGGER.info("Start");
		ArrayList<Question> questions = new ArrayList<>();
		
		try {
			questions = dao.myQuestion(userId);
			LOGGER.info("Get Account details ");
			LOGGER.debug("{}", questions);
			return Response.ok().entity(questions).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
		
	}

	
	
}
