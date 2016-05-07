package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Director implements Serializable{
	
	/*@PrimaryKey
	int director_ID=0;*/ //DONT KNOW SURE ABOUT THIS
	
	String name="";
	String surname="";
	
	@Persistent(mappedBy = "director", dependentElement = "true")
	@Join
	List<Movie> moviesDirector = new ArrayList<Movie>();

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Director(String name, String surname,List<Movie> moviesDirector) {
		super();
		this.name = name;
		this.surname = surname;
		this.moviesDirector = moviesDirector;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	


}
