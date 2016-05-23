package com.moviemanager.client.GraficalInterfaces;

import java.rmi.RemoteException;

import com.moviemanager.client.GraficalInterfaces.remote.RMIServiceLocator;

public class FRegister extends Register {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Boolean name = false;
	Boolean password = false;
	Boolean email = false;
	String nameS, passwordS, emailS;
	RMIServiceLocator rmi;
	String IP,port,serverName;

	public FRegister(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
	}

	private void getInfo() {
		if (!textUsername.getText().equals(null))
			name = true;

		if (!txtPassword.getText().equals(null))
			password = true;

		if (!txtEmail.getText().equals(null))
			email = true;
	}

	public void getData() {
		nameS = textUsername.getText();
		passwordS = txtPassword.getText();
		emailS = txtEmail.getText();
	}

	@Override

	protected void suscribe() {
		getInfo();
		if (name && password && email) {

			getData();
			try {
				rmi.getService().addUser(nameS, passwordS, emailS);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("You have not introduced the username, the password or the email.");
		}
		this.dispose();
		new FLogin(IP, port, serverName);
	}
}