package com.moviemanager.client;

import com.moviemanager.client.GraficalInterfaces.*;


import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.awt.EventQueue;

import com.moviemanager.server.IServer;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
/*
		try {
			
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			IServer objHello = (IServer) Naming.lookup(name);
			
			
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
*/

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
					IServer objHello = (IServer) java.rmi.Naming.lookup(name);
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error al establecer la conexion");
				}
			}
		});
    }
}
