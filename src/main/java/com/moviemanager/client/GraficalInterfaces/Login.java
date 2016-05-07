package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JButton;



import com.moviemanager.client.*;
import com.moviemanager.server.jdo.User;

//clase principal
public class Login extends JFrame{
	
	public static User usu;
	public JFrame frame;
	public JTextField textFieldNick;
	public JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conexionBd = DataBase.initBD("MovieRate.sqlite");
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error al establecer la conexion");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setFont(new Font("Showcard Gothic", Font.PLAIN, 44));
		lblLogin.setBounds(113, 23, 284, 48);
		frame.getContentPane().add(lblLogin);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(123, 86, 190, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(123, 128, 190, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNick.setBounds(26, 87, 46, 14);
		frame.getContentPane().add(lblNick);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(26, 129, 77, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(335, 105, 89, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio del programa");
				//primero busco a ver si está el usuario registrado
				 usu = DBUser.login(textFieldNick.getText(), textFieldPassword.getText()); 
				if(usu!=null){
					Gui a=new Gui();
					a.frame.setVisible(true);
				}
				//si no está registrado
				else{
					//JOptionPane que muestre en pantalla mensaje de error
					JOptionPane.showMessageDialog( null, "Error al introducir los campos.");
					System.out.println("Error. El nick y la contraseña no coinciden con los de ningún usuario.");
				}
		}
	});
		
		JButton btnRegistrarse = new JButton("Register");
		btnRegistrarse.setBounds(317, 159, 107, 23);
		frame.getContentPane().add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				Register a=new Register();
				a.frame.setVisible(true);
			}
		});
		
		JLabel lblIfYouDont = new JLabel("If you don\u00B4t have register... Click in this button");
		lblIfYouDont.setBounds(36, 163, 277, 14);
		frame.getContentPane().add(lblIfYouDont);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(165, 227, 89, 23);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
}
}
