package com.atos.qandaproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.qandaproject.model.AnswerModel;
import com.atos.qandaproject.repository.AnswerRepository;

@Service
@Transactional
public class AnswerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public void save(AnswerModel answerModel) {
		answerRepository.save(answerModel);
		
	}
	
	public List<AnswerModel> getAns(int questionId)
	{
		return answerRepository.getAnswerId(questionId);
	}
	

}
