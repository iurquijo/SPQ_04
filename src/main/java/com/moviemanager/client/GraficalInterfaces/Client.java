package com.moviemanager.client.GraficalInterfaces;


import java.rmi.RMISecurityManager;
import com.moviemanager.server.*;

public class Client {

	public static void main(String[] args) {
		
		
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			new Delegate_Login("127.0.0.1", args[1], args[2]);
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}