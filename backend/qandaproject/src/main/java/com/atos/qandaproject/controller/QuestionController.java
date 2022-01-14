package com.atos.qandaproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.qandaproject.model.QuestionModel;
import com.atos.qandaproject.model.UserModel;
import com.atos.qandaproject.service.QuestionService;
import com.atos.qandaproject.service.UserService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	UserModel user = new UserModel();
	@Autowired
	private QuestionService questionService;
	
@PostMapping
public void createQuestion(@RequestBody QuestionModel questionModel) {
	questionService.save(questionModel);
	
}
@GetMapping
public List<QuestionModel> getQuestions(){
	return this.questionService.getAllQuestion();
	
}

@GetMapping("{id}")
public QuestionModel getQuestion(@PathVariable int id)
{
	return questionService.getParticularQuestion(id);
}

@GetMapping("/user/{id}")
public List<QuestionModel> get(@PathVariable int id)
{
	return questionService.get(id);
}

	
}