package com.moviemanager.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdGeneratorStrategy;

import java.util.*;

/**
 * Created by sesion on 03/05/2016.
 */
@PersistenceCapable
public class PlayLst implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
    private String name="";
    private User user;
    private ArrayList<Mov> playlistMovie = new ArrayList<Mov>();

    
    public PlayLst() {
        name = "Untitled";
        playlistMovie = new ArrayList<Mov>();
    }

    public PlayLst(String name) {
        this.name = name;
        playlistMovie = new ArrayList<Mov>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Mov> getplaylist() {
        return playlistMovie;
    }

    public void setplaylist(ArrayList<Mov> playlist) {
        this.playlistMovie = playlist;
    }


    public void introduceFilm(Mov film, int position){
    	playlistMovie.add(position, film);
    }

    public void introduceFilm(Mov film){
    	playlistMovie.add(film);
    }

    public void removeFilm(int pos){
    	playlistMovie.remove(pos);

    }

    public void replaceFilm(int pos, Mov film){
    	playlistMovie.remove(pos);
    	playlistMovie.add(pos, film);
    }

   
}

    	
    	




