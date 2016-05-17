package com.moviemanager.client.GraficalInterfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textUsername;
	protected JTextField txtPassword;
	protected JTextField txtEmail;
	protected JButton registerButton;
	protected JLabel txtpnIntroduceUserName;
	protected JLabel txtpnIntroducePassword;
	protected JLabel txtpnIntroduceEmail;

	public Register() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(406, 307);

		registerButton = new JButton("Register");
		registerButton.setBounds(78, 234, 89, 23);
		getContentPane().add(registerButton);
		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				suscribe();
			}
		});

		txtpnIntroduceUserName = new JLabel("Username:");
		txtpnIntroduceUserName.setBounds(10, 48, 136, 23);
		getContentPane().add(txtpnIntroduceUserName);

		textUsername = new JTextField();
		textUsername.setBounds(153, 49, 136, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);

		txtpnIntroducePassword = new JLabel("Password:");
		txtpnIntroducePassword.setBounds(10, 156, 136, 20);
		getContentPane().add(txtpnIntroducePassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(153, 156, 136, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		txtpnIntroduceEmail = new JLabel("Email:");
		txtpnIntroduceEmail.setBounds(10, 102, 136, 20);
		getContentPane().add(txtpnIntroduceEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(153, 102, 136, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.setBounds(210, 234, 112, 23);
		getContentPane().add(btnBackToLogin);
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login a=new Login();
				a.setVisible(true);
			}
		});

		repaint();
	}

	protected void suscribe() {

	}
}