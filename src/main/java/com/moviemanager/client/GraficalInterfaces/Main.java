package com.moviemanager.client.GraficalInterfaces;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JTable table;
	protected String[] names = {"Telepizza", "Deustoarrak", "Foster","MejicanoTere", "Smoking yewepe"};
	protected String[] places = {"Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorys = {"Mexican", "Italian", "American", "Asian", "Basque" };
	protected String[] rates = {"1", "2", "3", "4", "5" };
	protected JLabel UserNameLabel;
	protected JButton logoutButton;
	protected JButton findButton;
	protected JButton openMovieButton;
	protected Panel panel;
	protected JComboBox<String> comboBoxName;
	protected JComboBox<String> comboBoxCategory;
	protected JComboBox<String> comboBoxPlace;
	protected JComboBox<String> comboBoxRate;
	protected JScrollPane scrollPane;
	protected JLabel logoLabel;
	

	protected String[] namesTriki = { "Name","Telepizza", "Deustoarrak", "Foster","MejicanoTere", "Smoking yewepe" };
	protected String[] placesTriki = { "Place","Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorysTriki = { "Category","Mexican", "Italian", "American", "Asian" };
	protected String[] ratesTriki = { "Rate","1", "2", "3", "4", "5" };

	public Main() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		UserNameLabel = new JLabel("User A");
		UserNameLabel.setBounds(469, 34, 54, 14);
		UserNameLabel.setEnabled(false);
		panel.add(UserNameLabel);

		logoutButton = new JButton("Logout");
		logoutButton.setBounds(542, 30, 81, 23);
		panel.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});

		openMovieButton = new JButton("Open");
		openMovieButton.setBounds(570, 350,81,23);
		panel.add(openMovieButton);
		openMovieButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openMovie();
			}
		});
		comboBoxName = new JComboBox<String>();
		comboBoxName.setBounds(93, 88, 120, 20);
		comboBoxName.setModel(new DefaultComboBoxModel<String>(namesTriki));
		panel.add(comboBoxName);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBounds(278, 88, 96, 20);
		comboBoxCategory.setModel(new DefaultComboBoxModel<String>(categorysTriki));
		panel.add(comboBoxCategory);

		comboBoxPlace = new JComboBox<String>();
		comboBoxPlace.setBounds(93, 113, 120, 20);
		comboBoxPlace.setModel(new DefaultComboBoxModel<String>(placesTriki));
		panel.add(comboBoxPlace);

		comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(278, 113, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		panel.add(comboBoxRate);
		table = new JTable(10,3);

		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(60, 168, 477, 303);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.RED));;
		panel.add(scrollPane);


		findButton = new JButton("Find");
		findButton.setBounds(434, 97, 89, 23);
		panel.add(findButton);
		findButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						execute();
					}
				});
			}
		});
		
		this.setVisible(true);

	}
	
	protected void execute(){
		
	}
	
	protected void logout(){
		
	}
	
	protected void openMovie() {
		
	}
}