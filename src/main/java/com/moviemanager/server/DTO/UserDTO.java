package com.moviemanager.server.DTO;

import java.io.Serializable;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nick;
	private String passWord;
	public UserDTO(){}
	public UserDTO(String nick, String password){
		System.out.println(nick+"                      "+password);
		this.nick = nick;
		this.passWord = password;
	}
	
	public String getNick(){
		return this.nick;
	}
	
	public String getPassword(){
		return this.passWord;
	}
}