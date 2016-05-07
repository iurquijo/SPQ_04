package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Movie {
	
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	int movie_ID=0;
	
	String name="";
	String description="";
	String rating="";
	
	@Persistent(mappedBy = "movie", dependentElement = "true")
	@Join
	List<Comment> commentsMovie = new ArrayList<Comment>();
	
	@Persistent(mappedBy = "movie", dependentElement = "true")
	@Join
	List<Director> directors= new ArrayList<Director>();
	
	@Persistent(mappedBy = "movie", dependentElement = "true")
	@Join
	List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String name, String description, String rating, List<Comment> commentsMovie, List<Director> directors, List<Actor> actor ) {
		super();
		this.name = name;
		this.description = description;
		this.commentsMovie = commentsMovie;
		this.directors = directors;
		this.actors = actors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public String getRating() { return rating; }

}
