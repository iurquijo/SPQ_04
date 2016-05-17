package com.moviemanager.server.DAO;

import com.moviemanager.server.jdo.*;

public interface IUserDAO {
	public void storeUser (User u);
	public User retrieveUser (String login);
	public void updateUser (User u);

}