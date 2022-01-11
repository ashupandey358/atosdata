package com.atos.qandaproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.qandaproject.exception.InvalidCredentialsException;
import com.atos.qandaproject.model.UserModel;
import com.atos.qandaproject.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserService userService;

	@PostMapping("/login")
    public UserModel customerAuthentication(@RequestBody UserModel userModel) {
		LOGGER.debug(" {}", userModel);
		String emailRecived = userModel.getEmail();
		String passwordRecived = userModel.getPassword();
		UserModel returnUserModel = userService.getUserByEmail(emailRecived);
		LOGGER.debug("{}", returnUserModel);
		if (returnUserModel == null) {
			throw new InvalidCredentialsException("Enter Valid Credntials");
		} else if (emailRecived.equals(returnUserModel.getEmail())
				&& passwordRecived.equals(returnUserModel.getPassword())) {
			return returnUserModel;
		} else {
			throw new InvalidCredentialsException("Enter Valid Credntials");
		}

	}

	@PostMapping
	public void create(@RequestBody UserModel userModel)
	{
		userService.save(userModel);

	}
}