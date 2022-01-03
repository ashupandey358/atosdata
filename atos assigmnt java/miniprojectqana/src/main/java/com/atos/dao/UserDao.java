package com.atos.dao;



import com.atos.exception.AppException;
import com.atos.model.User;

public interface UserDao {
	
	public void create(User user) throws AppException;
	public User getUser(String email) throws AppException;
	public void updateUser(int id) throws AppException;
	public void deleteUser(int id) throws AppException;

}
