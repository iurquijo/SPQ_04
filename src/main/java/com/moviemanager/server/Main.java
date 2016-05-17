package com.moviemanager.server;

import java.rmi.Naming;

public class Main {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String serverName = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			
			IServer server = new Server();
//			((Server) server).createDatabase();

			Naming.rebind(serverName, server);
			System.out.println(" Server "+serverName+" active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}