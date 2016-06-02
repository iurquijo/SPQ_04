package com.moviemanager.client.GraficalInterfaces;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Label;

public class MovieWindow extends JFrame {

	protected JTextField textField_UserName;
	protected JTextField textField_Description;
	protected String[] books = { "14:00", "14:30", "15:00", "21:00", "21:30", "22:00" };
	protected String[] booksTriki = { "Hour", "14:00", "14:30", "15:00", "21:00", "21:30", "22:00" };
	protected String[] rates = { "1", "2", "3", "4", "5" };
	protected String[] ratesTriki = { "Rate", "1", "2", "3", "4", "5" };
	protected JTextField textField_CommentText;
	protected JTextField textField_Name;
	protected JTextField textField_Location;
	protected JTextField textField_Rate;
	protected JTextPane txtpnComment;
	protected final JComboBox<String> comboBoxRate;

	public MovieWindow() {
		setSize(840, 470);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 24, 379, 153);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel txtpnName = new JLabel();
		txtpnName.setText("Name:");
		txtpnName.setBounds(10, 11, 50, 20);
		panel_1.add(txtpnName);

		JLabel txtpnRate = new JLabel();
		txtpnRate.setText("Rate:");
		txtpnRate.setBounds(10, 59, 50, 20);
		panel_1.add(txtpnRate);

		textField_Description = new JTextField("Description");
		textField_Description.setBounds(10, 90, 359, 56);
		panel_1.add(textField_Description);

//		BufferedImage img_Restaurant = null;
//		try {
////			img_Restaurant = ImageIO.read(new File(imgPhotoRestaurant)); // falta
//																			// poner
//																			// la
//			// referencia
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		Image dimg_Restaurant = img_Restaurant.getScaledInstance(lbl_photoRestaurant.getWidth(),
//				lbl_photoRestaurant.getHeight(), Image.SCALE_SMOOTH);

//		ImageIcon imageIcon_Restaurant = new ImageIcon(dimg_Restaurant);

//		lbl_photoRestaurant.setIcon(imageIcon_Restaurant);

		textField_Name = new JTextField();
		textField_Name.setBounds(70, 11, 86, 20);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Rate = new JTextField();
		textField_Rate.setBounds(70, 59, 86, 20);
		panel_1.add(textField_Rate);
		textField_Rate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 181, 313, 249);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
/*
		JLabel lblNombre = new JLabel("User name:");
		lblNombre.setBounds(10, 57, 71, 28);
		panel_2.add(lblNombre);

		textField_UserName = new JTextField("UserName");
		textField_UserName.setBounds(68, 61, 86, 20);
		panel_2.add(textField_UserName);

		JLabel lblComentarios = new JLabel("Comments");
		lblComentarios.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblComentarios.setBounds(10, 15, 255, 44);
		panel_2.add(lblComentarios);

		textField_CommentText = new JTextField();
		textField_CommentText.setBounds(68, 92, 235, 121);
		panel_2.add(textField_CommentText);
		textField_CommentText.setColumns(10);

		txtpnComment = new JTextPane();
		txtpnComment.setText("Comment:");
		txtpnComment.setBounds(10, 92, 55, 28);
		panel_2.add(txtpnComment);

		JButton btnComment = new JButton("Comment button");
		btnComment.setBounds(172, 226, 131, 23);
		panel_2.add(btnComment);

		btnComment.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				comment();
			}
		});
*/
		JButton btn_Rate = new JButton("Rate button");
		btn_Rate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rate();
			}
		});
		btn_Rate.setBounds(374, 253, 96, 23);
		getContentPane().add(btn_Rate);

	/*	final JComboBox<String> comboBoxBook = new JComboBox<String>();
		comboBoxBook.setBounds(261, 137, 96, 20);
		comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
		getContentPane().add(comboBoxBook);
		comboBoxBook.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
				comboBoxBook.setSelectedIndex(0);
				repaint();
			}
			public void focusGained(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(books));
				repaint();
			}
		});*/

		comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(374, 209, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		getContentPane().add(comboBoxRate);

		JButton btn_Logout = new JButton("Close");
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		btn_Logout.setBounds(411, 24, 89, 23);
		getContentPane().add(btn_Logout);
		repaint();

	}

	protected void putData() {
	}

	protected void rate() {
	}

	protected void comment() {
	}

	protected void logout() {
	}
}