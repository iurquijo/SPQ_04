package com.moviemanager.client.GraficalInterfaces;


import java.rmi.RemoteException;

import com.moviemanager.client.GraficalInterfaces.remote.RMIServiceLocator;
import com.moviemanager.server.DTO.UserDTO;


public class FLogin extends Login {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Boolean name = false;
	Boolean password = false;
	String username = "";
	String passwordS = "";
	String IP, port, serverName;
	RMIServiceLocator rmi;
	
	public FLogin(String IP, String port, String serverName) {

		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
	}

	private void getInfo() {
		if (!textFieldUsername.getText().equals("Username"))
			name = true;

		if (!textFieldPassword.getText().equals("Password"))
			password = true;
	}

	private void getData() {

		username = textFieldUsername.getText();
		passwordS = textFieldPassword.getText();
	}

	@Override
	protected void register() {
		this.dispose();
		new FRegister(IP, port, serverName);
	}
	
	@Override
	protected void login() {
		getInfo();
		getData();
		UserDTO userDTO = new UserDTO("", "");
		try {
			userDTO = rmi.getService().retrieveUser(username);
			System.out.println("USERNAME" + userDTO.getPassword());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (name && password) {
			if (userDTO.getPassword().equals(passwordS)) {
				System.out.println("USER IS CORRECT");
				this.dispose();
					new FMain(IP, port, serverName, userDTO);
			} else
				System.out.println("The password or the username are not correct.");
		} else {
			System.out.println("You have not introduced the username or the password.");
		}
	}
	
}