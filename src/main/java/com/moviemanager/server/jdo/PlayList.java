package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


import java.util.*;

/**
 * Created by sesion on 03/05/2016.
 */
@PersistenceCapable
public class PlayList implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String name="";
    private User user;
    private ArrayList<Movie> playlistMovie = new ArrayList<Movie>();

    
    public PlayList() {
        name = "Untitled";
        playlistMovie = new ArrayList<Movie>();
    }

    public PlayList(String name) {
        this.name = name;
        playlistMovie = new ArrayList<Movie>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getplaylist() {
        return playlistMovie;
    }

    public void setplaylist(ArrayList<Movie> playlist) {
        this.playlistMovie = playlist;
    }


    public void introduceFilm(Movie film, int position){
    	playlistMovie.add(position, film);
    }

    public void introduceFilm(Movie film){
    	playlistMovie.add(film);
    }

    public void removeFilm(int pos){
    	playlistMovie.remove(pos);

    }

    public void replaceFilm(int pos, Movie film){
    	playlistMovie.remove(pos);
    	playlistMovie.add(pos, film);
    }

   
}

    	
    	




