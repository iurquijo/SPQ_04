package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdGeneratorStrategy;
@PersistenceCapable
public class Drector implements Serializable{
	
	/*@PrimaryKey
	int director_ID=0;*/ //DONT KNOW SURE ABOUT THIS
	@PrimaryKey
	String name="";
	String surname="";
	
	/*@Persistent(mappedBy = "director", dependentElement = "true")
	@Join*/
	List<Mov> moviesDirector = new ArrayList<Mov>();

	public Drector() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Drector(String name, String surname,List<Mov> moviesDirector) {
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
