package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import com.moviemanager.client.*;
import com.moviemanager.server.jdo.Movie;

public class Search {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
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

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(171, 215, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				Gui a=new Gui();
				a.frame.setVisible(true);
			}
		});
	

		JLabel lblSearchMovies = new JLabel("Search Movies");
		lblSearchMovies.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblSearchMovies.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMovies.setBounds(156, 11, 110, 39);
		frame.getContentPane().add(lblSearchMovies);

		textField = new JTextField();
		textField.setBounds(51, 46, 225, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(309, 45, 89, 23);
		frame.getContentPane().add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Movie> resultList = SearchMovie.Search(textField.getText());

				Object[] columns = {"Name", "Description", "Rating"};
				DefaultTableModel model = new DefaultTableModel(columns,0);
				JTable resultTable = new JTable(model);
				resultTable.setBounds(84, 77, 277, 126);
				frame.getContentPane().add(resultTable);

				for(Movie M : resultList){
					Object[] data = {M.getName(), M.getDescription(), M.getRating()};
					model.addRow(data);
				}
			}
		});
		
	}
}
