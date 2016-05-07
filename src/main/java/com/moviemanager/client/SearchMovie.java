package com.moviemanager.client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.moviemanager.server.jdo.Movie;

/**
 * Created by serhatsahin on 19.04.2016.
 */


public class SearchMovie {

    public static List<Movie> Search(String keyword){
        Movie m = null;
        List<Movie> movieList = new ArrayList<>();
        ResultSet rs = null;
        String sql = null;
        Connection conn = DataBase.initBD("/Users/serhatsahin/Desktop/movie-manager/MovieRate.sqlite");
        //Statement statement = DataBase.getStatement();
        try {
            sql = "SELECT * FROM Movie WHERE Name LIKE ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, "%" + keyword + "%");
            rs = prep.executeQuery();

            while(rs.next()){
                m = new Movie();
                m.name = rs.getString(1).toString();
                m.description = rs.getString(2).toString();
                m.rating = rs.getString(3).toString();
                movieList.add(m);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
          //  DataBase.close();
        }
        return movieList;
    }

	public Object frame;

}
