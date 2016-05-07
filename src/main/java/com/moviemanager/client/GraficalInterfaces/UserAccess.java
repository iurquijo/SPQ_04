package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UserAccess {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccess window = new UserAccess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserAccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMovieManager = new JLabel("Movie Manager");
		lblMovieManager.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblMovieManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieManager.setBounds(119, 28, 214, 26);
		frame.getContentPane().add(lblMovieManager);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(102, 117, 89, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener(){
	    public void actionPerformed (ActionEvent e){
	       System.out.println("Acceso a la ventana del Login");
	       Login a=new Login();
	       a.frame.setVisible(true);
	    }
	    });
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(259, 117, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent e){
			System.out.println("Acceso a la ventana del Registro");
			Register a=new Register();
			a.frame.setVisible(true);
		}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(183, 165, 89, 23);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent e){
			System.out.println("Salir de la aplicación");
			System.exit(0); 
		}
		});
	}
}
