package com.moviemanager.server.jdo;

import java.io.Serializable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Comment implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String text = null;
	User user = null;
	Movie movie = null;

	public Comment(String text, User user, Movie movie) {
		super();
		this.text = text;
		this.movie = movie;
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return null;
	}
	
	public Movie getMovie(){
		return this.movie;
	}

}