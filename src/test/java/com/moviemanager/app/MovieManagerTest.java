package com.moviemanager.app;


import org.junit.*;

import com.moviemanager.server.jdo.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;


public class MovieManagerTest {

    //======MOVIE=====
    private Mov agora;
    //==COMMENT=====
    Comment com;
    String text;
    User user;

    //====USER====
    String mail;
    String nick;
    String password;
    List<Comment> commentsUser;
    List<PlayLst> playListsUser;

    @Before
    public void setUp() {
        agora = new Mov();
        com = new Comment();
        String text = "";
        String mail = "gmail@gmail.com";
        String nick = "Nickname";
        String password = "Password";
        List<Comment> commentsUser = null;
        List<PlayLst> playListsUser = null;
        User user = new User( mail,  nick,  password,  commentsUser, playListsUser);
    }

    @Test
    public void testInitializeMovie() {
        boolean test = false;
        String nameM = "Agora";
        String rate = "rate";
        String numRates = "1";
        String description = "this is a film";
        Drector director = new Drector();
        List<Comment> commentsM = null;
        List<Actor> actorsM = null;

        agora = new Mov(nameM, rate, numRates, description, director, commentsM, actorsM);

        if((agora.getNameM() == "Agora") && (agora.getRate() == "rate")){
            //for example few values
            test = true;
        }
        assertTrue(test);
    }

    @Test
    public void testcomment(){
        com = new Comment(text, user, agora);
        boolean test = agora.addComment(com);
        assertTrue(test);
    }

    @Test
    public void testSearchMoviesByName(){
        boolean test = false;
        String nameOne = "Agora";
        String nameTwo = "The Godfather";


        //create a playlist and add Agora to it
        Mov movie = new Mov();
        movie.setNameM(nameOne);
        ArrayList<Mov> list = new ArrayList<>();

        list.add(0, movie);
        PlayLst pl = new PlayLst(list);


        //pl.setplaylist(list);

        //Search the film The Godfather in the playlist
        Mov searchedMovie = null;
        searchedMovie= pl.searchMovieInPlayListByName(nameTwo);

        //The movie TheGodfather isn't in the playlist, so the asert is false
        if((searchedMovie != null)&&(searchedMovie.getNameM().equals(nameTwo))){
            test = true;
            assertTrue(test);
        }else{
            assertTrue(test);
        }
    }

}