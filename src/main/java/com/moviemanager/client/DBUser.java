package com.moviemanager.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.moviemanager.server.jdo.User;



public class DBUser {
	
	
	public static User login(String nick, String password){
		User u=null;
		Statement stat = DataBase.getStatement();
		System.out.println(stat);
		ResultSet rs;
		String sql = null;
		try {
			sql = "select * from user where nick = '"+nick+"' and password='"+password+"'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				u = new User(rs.getString("nick"), rs.getString("password"), rs.getString("name"), rs.getString("surname"), rs.getString("mail"));
			}
			
			rs.close();
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR Login: "+sql);
			System.out.println("ERROR Login: "+e.getMessage());
		}
		return u;
	}
	
	public static User register(String nick, String password, String name, String surname, String mail){
		User u=null;
		Statement stat = DataBase.getStatement();
		String sql = null;
		try {
			sql = "insert into User values('"+nick+"','"+password+"','"+name+"','"+surname+"','"+mail+"')";
			int filas=stat.executeUpdate(sql);
			if(filas==1)
				u = new User(nick,password,name,surname,mail);		
			stat.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR register: "+sql);
		}
		
		return u;
	}
	
}
