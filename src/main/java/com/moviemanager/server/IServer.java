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
	public List<MovieDTO> getMovieByCategory(String text) throws RemoteException ;
	public List<MovieDTO> getMovieByPlace(String text)throws RemoteException ;
	public List<MovieDTO> getMovieByRate(String text)throws RemoteException ;
	public List<MovieDTO> getMovieByNameAndCategory(String text, String text1)throws RemoteException ;
	public List<MovieDTO> getMovieByNameAndRate(String text, String text1)throws RemoteException  ;
	public List<MovieDTO> getMovieByNameAndPlace(String text, String text1) throws RemoteException ;
	public List<MovieDTO> getMovieByPlaceAndCategory(String text, String text1)throws RemoteException ;
	public List<MovieDTO> getMovieByPlaceAndRate(String text, String text1)throws RemoteException ;
	public List<MovieDTO> getMovieByCategoryAndRate(String text, String text1)throws RemoteException ;
	public boolean setComment(Comment comment)throws RemoteException;
	public boolean addRateToMovie(Movie movie, String newRate) throws RemoteException;
	public UserDTO retrieveUser(String name)throws RemoteException ;
	public boolean addUser(String name, String password, String email)throws RemoteException;
}