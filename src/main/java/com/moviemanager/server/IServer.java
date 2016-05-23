package com.moviemanager.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;
import javax.jdo.Query;
import com.moviemanager.server.DTO.MovieDTO;
import com.moviemanager.server.DTO.UserDTO;

import com.moviemanager.server.jdo.*;


public interface IServer extends Remote {
	
	public List<MovieDTO> getMovieByName(String text) throws RemoteException;
	public List<MovieDTO> getMovieByRate(String text)throws RemoteException ;
	public List<MovieDTO> getMovieByNameAndRate(String text, String text1)throws RemoteException;
	
	public boolean setComment(String text, MovieDTO movie, UserDTO userDTO)throws RemoteException;
	public boolean addRateToMovie(MovieDTO movie, String newRate) throws RemoteException;
	public UserDTO retrieveUser(String name)throws RemoteException ;
	public boolean addUser(String name, String password, String email)throws RemoteException;
}