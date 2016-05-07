package com.moviemanager.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	private static Connection connection = null;
	private static Statement statement = null;


	public static Connection initBD( String nameBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nameBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR en initBD");
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	public static Statement getStatement() {
		return statement;
	}

	
	public static void createDBTable() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table fichero_multimedia " +
				"(fichero string, error boolean, titulo string" +
				", cantante string, comentarios string)");
		} catch (SQLException e) {
	
		}
	}

}