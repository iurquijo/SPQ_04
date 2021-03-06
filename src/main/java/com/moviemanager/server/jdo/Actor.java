package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdGeneratorStrategy;
@PersistenceCapable
public class Actor implements Serializable {

	/*@PrimaryKey
	int actor_ID=0;*/ //DONT KNOW SURE ABOUT THIS
	@PrimaryKey
	String name;
	String surname;
	
	@Persistent(table="actors_movs")
	@Join(column="name")
	@Element(column="nameM")
	List<Mov> moviesActor = new ArrayList<Mov>();

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Actor(String name, String surname, List<Mov> moviesActor) {
		super();
		this.name = name;
		this.surname = surname;
		this.moviesActor = moviesActor;
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
