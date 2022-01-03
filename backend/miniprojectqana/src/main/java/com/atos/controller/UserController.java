package com.atos.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atos.dao.UserDao;
import com.atos.dao.impl.UserDaoImpl;
import com.atos.exception.AppException;
import com.atos.model.User;

@Path("/users")
public class UserController {
	
UserDao dao = new UserDaoImpl();
private static User currentUser;
public static User getCurrentUser() {
	return currentUser;
}
public static void setCurrentUser(User currentUser) {
	UserController.currentUser = currentUser;
}

private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

@GET
@Path("/{email}/{password}")
@Produces(MediaType.APPLICATION_JSON)
public Response loginDetails(@PathParam("email") String email,@PathParam("password") String password)
{
	LOGGER.info("start");
	
	try {
		User user = new User();
		user = dao.getUser(email);
		if(user==null)
		{
			LOGGER.info("Invaild password or email");
			return Response.status(401).build();
		}
		else if(user.getPassword().equals(password))
		{
			LOGGER.info("Login succesfully");
			LOGGER.debug("{}",user);
			UserController.setCurrentUser(user);
			return Response.ok().entity(user).build();
		}
		else
		{
			LOGGER.info("invalid password or email");
			return Response.status(401).build();
		}
	} catch (AppException e) {
		return Response.status(500).build();
	}
}

}
