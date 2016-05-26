package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User{

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	String mail = "";
	@PrimaryKey
	String nick = "aitor";
	String password = "aitor";

	/*@Persistent(mappedBy = "user", dependentElement = "true")
	@Join*/
	List<Comment> commentsUser = new ArrayList<Comment>();
	
	/*@Persistent(mappedBy = "user", dependentElement = "true")
	@Join*/
	List<PlayLst> playListsUser = new ArrayList<PlayLst>();

	public User(){}
	
	public User(String mail, String nick, String password, List<Comment> commentsUser, List<PlayLst> playListsUser) {
		super();
		this.mail = mail;
		this.nick = nick;
		this.password = password;
		this.commentsUser = commentsUser;
		this.playListsUser = playListsUser;
	}

	public String getNick() {
		return this.nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public List<Comment> getCommentsUser() {
		return commentsUser;
	}

	public void setCommentsUser(List<Comment> commentsUser) {
		this.commentsUser = commentsUser;
	}
	
	public List<PlayLst> getPlayListUser() {
		return playListsUser;
	}

	public void setCommentsM(List<PlayLst> playListsUser) {
		this.playListsUser = playListsUser;
	}

}

	
	
