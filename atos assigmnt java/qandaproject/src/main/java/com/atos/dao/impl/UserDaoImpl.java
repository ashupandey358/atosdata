package com.atos.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atos.dao.UserDao;
import com.atos.dao.Util;
import com.atos.exception.AppException;
import com.atos.model.User;

public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public void create(User user) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",user);
		try(Connection connection = Util.getConnection())
		{
			String query = "INSERT INTO ATOSDB.users (ID, NAME, MOBILENUMBER, EMAIL, PASSWORD, PANNUMBER) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getMobileNumber());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getPanNumber());
			statement.executeUpdate();
			LOGGER.debug("Queary excute succesfully");
			LOGGER.info("end");
		} catch (SQLException e) {
			LOGGER.error("error inserting user",e);
			throw new AppException(e);
		}
		
		
	}

	@Override
	public User getUser(String email) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",email);
		User user = null;
		try (Connection connection = Util.getConnection()){
			String query = "select * from atosDb.users where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,email);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				int id = result.getInt("ID");
				String name = result.getString("NAME");
				String mobileNumber = result.getString("MOBILENUMBER");
				String email1 = result.getString("EMAIL");
				String password = result.getString("PASSWORD");
				String panNumber = result.getString("PANNUMMBER");
				user = new User(id,name,mobileNumber,email1,password,panNumber);
				LOGGER.debug("query excute succesfully");
				LOGGER.info("end");
			}
		} catch (SQLException e) {
			LOGGER.error("error inserting user",e);
			throw new AppException(e);
			
		}
		return user;
	}

	@Override
	public void updateUser(int id) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws AppException {
		// TODO Auto-generated method stub
		
		
	}

}
