package com.moviemanager.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	
	public void func() throws RemoteException;

}
