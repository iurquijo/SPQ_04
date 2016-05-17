package com.moviemanager.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.moviemanager.client.GraficalInterfaces.*;
import com.moviemanager.server.DAO.MovieAdvisorDAO;
import com.moviemanager.server.DTO.MovieDTO;
import com.moviemanager.server.DTO.UserDTO;

import java.util.HashMap;
import java.awt.EventQueue;

import java.util.List;

import com.moviemanager.server.jdo.*;


public class Server extends UnicastRemoteObject implements IServer {

	protected Server() throws RemoteException {
		super();
//		createDatabase();
	}

	private static final long serialVersionUID = 1L;
	private MovieAdvisorDAO dao = new MovieAdvisorDAO();

	
	public List<MovieDTO> getMovieByName(String text) throws RemoteException {
		return dao.getMovieByName(text);
	}

	public List<MovieDTO> getMovieByRate(String text) throws RemoteException {
		return dao.getMovieByRate(text);
	}

	public List<MovieDTO> getMovieByNameAndRate(String text, String text1)throws RemoteException  {
		return dao.getMovieByNameAndRate(text,text1);
	}

	public void createDatabase() {
		dao.createDatabase();
	}
	public boolean setComment(Comment comment)throws RemoteException  {
		return dao.storeComment(comment);
	}
	public boolean addRateToMovie(Movie movie, String newRate) throws RemoteException{
		return dao.addRateToMovie(movie, newRate);
	}
	public UserDTO retrieveUser(String name) throws RemoteException  {
		return dao.retrieveUser(name);
	}
	public boolean addUser(String name, String password, String email){
		return dao.addUser(name, password, email);
	}
	
}