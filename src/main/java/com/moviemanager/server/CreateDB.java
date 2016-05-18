package com.moviemanager.server;

import java.rmi.Naming;

public class CreateDB {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String serverName = "//" + "127.0.0.1" + ":" + args[1] + "/" + args[2];

		try {
			
			IServer server = new Server();
			((Server) server).createDatabase();
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}