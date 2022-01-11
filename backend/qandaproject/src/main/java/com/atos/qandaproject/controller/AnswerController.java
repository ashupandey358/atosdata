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

import com.atos.qandaproject.model.AnswerModel;
import com.atos.qandaproject.service.AnswerService;
import com.atos.qandaproject.service.UserService;

@RestController
@RequestMapping("/answers")
public class AnswerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	public void creat(@RequestBody AnswerModel answerModel) {
		answerService.save(answerModel);
		
	}
	
	@GetMapping("/{id}")
	public List<AnswerModel> setAns(@PathVariable int id) {
		return answerService.getAns(id);
	}
}
