package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Comment implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	int movie_ID = 0;
	String userMail = null;

	String text = null;
	User user = null;
	Movie movie = null;

	public Comment(String text, User user, Movie movie) {
		super();

		this.movie_ID = movie_ID;
		this.userMail = userMail;

		this.text = text;
		this.user = user;
		this.movie = movie;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {

		return "Comment [text=" + text + ", User=" + user + ", Movie=" + movie + "]";

	}

}