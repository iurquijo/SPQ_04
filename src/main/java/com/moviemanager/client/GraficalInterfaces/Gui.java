package com.moviemanager.client.GraficalInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.BevelBorder;

public class Gui {

	JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		 
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(583, 31, 1, 310);
		panel.setBorder(null);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(273, 202, -251, -96);
		panel.add(layeredPane);
		
		JTextArea txtrLatestFilms = new JTextArea();
		txtrLatestFilms.setBounds(0, 0, 584, 31);
		txtrLatestFilms.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrLatestFilms.setEditable(false);
		txtrLatestFilms.setBackground(SystemColor.scrollbar);
		txtrLatestFilms.setText("                 LATEST FILMS");
		frame.getContentPane().add(txtrLatestFilms);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setEnabled(true);
		menuBar.setBorderPainted(true);
		frame.setJMenuBar(menuBar);
		
		JMenu mnSearchFilms = new JMenu("Search films");
		menuBar.add(mnSearchFilms);
		
		JCheckBoxMenuItem orderByName = new JCheckBoxMenuItem("By name");
		mnSearchFilms.add(orderByName);
		orderByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search a= new Search();
				a.frame.setVisible(true);
								
			}
		});
		
		JCheckBoxMenuItem orderByDirector = new JCheckBoxMenuItem("By director");
		mnSearchFilms.add(orderByDirector);
		orderByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search a= new Search();
				a.frame.setVisible(true);
								
			}
		});

		JMenu mnLists = new JMenu("Lists");
		menuBar.add(mnLists);
		
		JMenuItem mntmCreateMovieList = new JMenuItem("Create movie list");
		mnLists.add(mntmCreateMovieList);
		
		JMenuItem mntmMyLists = new JMenuItem("My lists");
		mnLists.add(mntmMyLists);
		
		JMenu mnNewMenu_2 = new JMenu("Profile");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmMyProfile = new JMenuItem("My profile");
		mnNewMenu_2.add(mntmMyProfile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnNewMenu_2.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login a= new Login();
				a.frame.setVisible(true);
				
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnExit.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		

		
	}
}
