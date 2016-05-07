package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.moviemanager.client.*;
import com.moviemanager.server.jdo.User;


//Añadir funcionalidad al boton Salir

public class Register extends JFrame{

	JFrame frame;
	private JTextField textFieldNick;
	private JTextField textFieldPassword;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conexionBd = DataBase.initBD("MovieRate.sqlite");
					Register window = new Register();
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
	public Register() {
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
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setForeground(Color.DARK_GRAY);
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 19));
		lblNewUser.setBounds(116, 11, 184, 29);
		frame.getContentPane().add(lblNewUser);
		
		JLabel lblNick = new JLabel("Nick: ");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNick.setBounds(24, 81, 58, 21);
		frame.getContentPane().add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(68, 100, 107, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(24, 132, 101, 21);
		frame.getContentPane().add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(68, 164, 107, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(237, 51, 70, 14);
		frame.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(303, 76, 121, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(237, 98, 81, 21);
		frame.getContentPane().add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(303, 134, 121, 20);
		frame.getContentPane().add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMail.setBounds(237, 167, 126, 14);
		frame.getContentPane().add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(303, 196, 121, 20);
		frame.getContentPane().add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(105, 227, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Falta por poner error por JTextField vacio
				 * Introducir nuevo usuario en la BD
				 */
				System.out.println("Inicio del registro");
					User usu = DBUser.register(textFieldNick.getText(), textFieldPassword.getText(), textFieldName.getText(),textFieldSurname.getText(),textFieldMail.getText()); 
					if(usu!=null){
						//meter si el nick no está repetido
						//usu = UsuariosBD.añadirUsuariosBD(textFieldNick.getText(), textFieldContraseña.getText(), textFieldNombre.getText(),textFieldApellidos.getText(),textFieldCorreo.getText());
						Login a=new Login();
						a.frame.setVisible(true);
						System.out.println("Usuario añadido a la Base de Datos");
						System.out.println("Registro completado");
					}
					//si el nick está repetido o JTextField vacío
					else{
						//JOptionPane que muestre en pantalla mensaje de error
						JOptionPane.showMessageDialog( null, "Error.El nick ya existe o alguno de los campos está vacío.");
						System.out.println("Error. El nick del usuario ya existe o alguno de los campos está vacío.");
					}
			}
		});
		
		JButton btnBack = new JButton("Back to Login");
		btnBack.setBounds(237, 227, 120, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Back to Login");
				Login a=new Login();
				a.frame.setVisible(true);
			}
		});
	}
}