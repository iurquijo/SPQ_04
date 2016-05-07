package com.moviemanager.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.moviemanager.client.GraficalInterfaces.*;

import java.util.HashMap;
import java.awt.EventQueue;

public class Server extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		
	}

	public void func() throws RemoteException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error al establecer la conexion");
				}
			}
		});
	}


	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IServer objServer = new Server();
			Naming.rebind(name, objServer);
			System.out.println("Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("Hello exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
