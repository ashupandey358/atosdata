package com.atos.qandaproject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.qandaproject.model.QuestionModel;
import com.atos.qandaproject.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private QuestionRepository questionRepository;

	public List<QuestionModel> getAllQuestion() {
		return questionRepository.findAll();

	}
	
	public List<QuestionModel> get(int userId)
	{
		return questionRepository.getUserId(userId);
	}
	
	
	public void save(QuestionModel questionModel) {
		questionRepository.save(questionModel);
		
	}

}
