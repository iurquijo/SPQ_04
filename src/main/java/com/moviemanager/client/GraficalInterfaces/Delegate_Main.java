package com.moviemanager.client.GraficalInterfaces;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.moviemanager.client.GraficalInterfaces.remote.RMIServiceLocator;
import com.moviemanager.server.DTO.MovieDTO;
import com.moviemanager.server.DTO.UserDTO;

/*import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.*;*/

public class Delegate_Main extends Main{

	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean category = false;
	Boolean rate = false;
	Boolean place = false;
	List<MovieDTO> list;
	int contadorFilas = 0;
	UserDTO usDTO;
	String IP,port,serverName;
	
	public Delegate_Main(String IP, String port, String serverName, UserDTO userDTO) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.usDTO=userDTO;
		this.port = port;
		this.serverName = serverName;
		UserNameLabel.setText(userDTO.getNick());
		list = new ArrayList<MovieDTO>();
	}
	private void getComboBoxes(){
		name = false;
		category = false;
		rate = false;
		place = false;
		if(!comboBoxCategory.getSelectedItem().equals("Category"))
			category = true;

		if(!comboBoxName.getSelectedItem().equals("Name"))
			name = true;

		if(!comboBoxPlace.getSelectedItem().equals("Place"))
			place = true;

		if(!comboBoxRate.getSelectedItem().equals("Rate"))
			rate = true;
	}
	private void find(){
		getComboBoxes();
		if(!category && name && !place && !rate)
			try {
				System.out.println("NAME");
				list = rmi.getService().getMovieByName(comboBoxName.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && !place && rate)
			try {
				System.out.println("RATE");
				list = rmi.getService().getMovieByRate(comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && rate)
			try {
				System.out.println("NAME AND RATE");
				list = rmi.getService().getMovieByNameAndRate(comboBoxName.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void addToTable () {
		deleteFromTable();
		find();
		for (MovieDTO mov : list) {
		    table.setValueAt(mov.getNameM(), contadorFilas, 0);
		    table.setValueAt(mov.getDescription(), contadorFilas, 1);
		    table.setValueAt(mov.getRate(), contadorFilas, 2);
		    contadorFilas++;
		}
		scrollPane.repaint();
	
	}
	
	private void deleteFromTable() {
		
		for (int i = 0; i < 10; i++) {
		    table.setValueAt("", i, 0);
		    table.setValueAt("", i, 1);
		    table.setValueAt("", i, 2);
		}
		contadorFilas = 0;
		this.repaint();
	}
	
	protected void execute(){
		addToTable();
		this.repaint();
	}
	
	@Override
	protected void openMovie(){
		new Delegate_Movie(list.get(table.getSelectedRow()), IP,port,serverName);
		this.dispose();
	}
	
	protected void logout(){
		this.dispose();
		System.exit(1);
	}
	
}