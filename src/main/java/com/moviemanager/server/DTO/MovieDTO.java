package com.moviemanager.server.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.moviemanager.server.jdo.Actor;
import com.moviemanager.server.jdo.Drector;
import com.moviemanager.server.jdo.Mov;
import com.moviemanager.server.jdo.Comment;

public class MovieDTO implements Serializable{

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */

	@PrimaryKey
	String nameM = null;
	String rate = null;
	String numRates = null;
	String description=null;
	Drector director=null;

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsM = new ArrayList<Comment>();
	
	@Persistent(mappedBy = "movie", dependentElement = "true")
	@Join
	List<Actor> actorsM = new ArrayList<Actor>();
	public MovieDTO(){
		this.nameM="";
		this.rate="";
		this.numRates="";
		this.description="";
		this.director=null;
		
	}
	public MovieDTO (Mov movie) {
		super();
		this.nameM = movie.getNameM();
		this.rate = movie.getRate();
		this.numRates = movie.getNumRates();
		this.description = movie.getDescription();
		this.director = movie.getDirector();
		this.commentsM = commentsM;
		this.actorsM = actorsM;
	}
	public MovieDTO (String nameM, String rate, String numRates,
			String description, Drector director, List<Comment> commentsM,List<Actor> actorsM) {
		super();
		this.nameM = nameM;
		this.rate = rate;
		this.numRates = numRates;
		this.description = description;
		this.director=director;
		this.commentsM = commentsM;
		this.actorsM = actorsM;
	}
	private static final long serialVersionUID = 1L;
	
	public String getNameM() {
		return nameM;
	}

	public void setNameR(String nameM) {
		this.nameM = nameM;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getNumRates() {
		return numRates;
	}

	public void setNumRates(String numRates) {
		this.numRates = numRates;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Drector getDirector() {
		return director;
	}

	public void setDirector(Drector director) {
		this.director= director;
	}

	public List<Comment> getCommentsM() {
		return commentsM;
	}

	public void setCommentsM(List<Comment> commentsM) {
		this.commentsM = commentsM;
	}

	public List<Actor> getActorsM() {
		return actorsM;
	}

	public void setActorsM(List<Actor> actorsM) {
		this.actorsM = actorsM;
	}

}