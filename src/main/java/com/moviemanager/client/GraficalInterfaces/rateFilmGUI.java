package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class rateFilmGUI extends JFrame{

	private JFrame frame;
	private JTextField textField;
	protected JTextField textField_CommentText;
	protected JTextPane txtpnComment;
	protected JTextField textField_UserName;
	private JTextField textField_Rate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rateFilmGUI window = new rateFilmGUI();
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
	public rateFilmGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(507, 193, 313, 249);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFilm = new JLabel("Movie Name");
		lblFilm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilm.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblFilm.setBounds(192, 11, 255, 44);
		panel_2.add(lblFilm);
		
		JLabel lblNombre = new JLabel("User name:");
		lblNombre.setBounds(300, 244, 71, 28);
		panel_2.add(lblNombre);

		textField_UserName = new JTextField();
		textField_UserName.setEditable(false);
		textField_UserName.setBounds(378, 248, 86, 20);
		panel_2.add(textField_UserName);
		textField_UserName.setColumns(10);

		textField_CommentText = new JTextField();
		textField_CommentText.setBounds(300, 283, 235, 121);
		panel_2.add(textField_CommentText);
		textField_CommentText.setColumns(10);

		txtpnComment = new JTextPane();
		txtpnComment.setText("Comment:");
		txtpnComment.setBounds(204, 283, 71, 28);
		panel_2.add(txtpnComment);

		JButton btnComment = new JButton("COMMENT");
		btnComment.setBounds(446, 413, 89, 23);
		panel_2.add(btnComment);
		
		textField_Rate = new JTextField();
		textField_Rate.setBounds(300, 142, 128, 20);
		panel_2.add(textField_Rate);
		textField_Rate.setColumns(10);
		
		JButton btnRate = new JButton("Rate");
		btnRate.setBounds(186, 141, 89, 23);
		panel_2.add(btnRate);

		btnComment.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//comment();
			}
		});

	}
}
