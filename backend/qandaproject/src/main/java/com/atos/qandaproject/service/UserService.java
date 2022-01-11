package com.atos.qandaproject.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.qandaproject.model.UserModel;
import com.atos.qandaproject.repository.UserRepository;

@Service
@Transactional

public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public void save(UserModel userModel) {

		userRepository.save(userModel);

	}
	
	public UserModel getUserByEmail(String email) {
		return userRepository.findByEmail(email);		
				
	}

}