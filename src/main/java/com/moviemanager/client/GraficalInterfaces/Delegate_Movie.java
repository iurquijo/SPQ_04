package com.moviemanager.client.GraficalInterfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.moviemanager.client.Movie;
import com.moviemanager.client.User;
import com.moviemanager.client.GraficalInterfaces.remote.RMIServiceLocator;
import com.moviemanager.server.DTO.MovieDTO;
import com.moviemanager.server.jdo.Comment;

/*import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;*/

public class Delegate_Movie extends MovieWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MovieDTO movieDTO;
	Movie movie;
	User user;
	RMIServiceLocator rmi;
	boolean rate = false;

	public Delegate_Movie(MovieDTO movieDTO, String IP, String port, String serverName) {
		this.movieDTO = movieDTO;
		this.user = user;
		this.movie = new Movie(movieDTO.getNameR(),
				movieDTO.getRate(),
				movieDTO.getNumRates(),
				movieDTO.getCategory(),
				movieDTO.getStreet(),
											new ArrayList<Comment>(),
											movieDTO.getCity());
		rmi = new RMIServiceLocator(IP, port, serverName);
		putData();
	}

	private void getComboBoxe() {

		if (!comboBoxRate.getSelectedItem().equals("Rate"))
			rate = true;

	}

	@Override
	protected void rate() {
		getComboBoxe();
		if (rate) {
			try {
				rmi.getService().addRateToMovie(movie, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void putData() {
		textField_Name.setText(movie.getNameR());
		textField_Location.setText("city: "
				+ movie.getCity().getNameCity() + ", street: " + movie.getStreet());
		textField_Description.setText(movie.getDescription());
		textField_Rate.setText(movie.getRate() + "   (" + movie.getNumRates() + " rates)");
		imgPhotoRestaurant = movie.getPathImagen();
//		textField_UserName.setText(user.getName());
//		textNombreDelUsuarioArriba.setText(user.getName());

	}

	@Override
	protected void comment() {
		String text = textField_CommentText.getText();
		Comment comment = new Comment(text, new Movie(MovieDTO), userDTO);
		try {
			rmi.getService().setComment(comment);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void logout() {
		this.dispose();
		new Delegate_Main(IP, port, serverName, userDTO);
	}

	@Override
	protected void goMainWindow() {
		super.goMainWindow();
	}
	
	
}