/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment6part3.DAO;

import com.mycompany.assignment3part6.pojo.Movie;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author kamuni.saheeshna
 */
public class MovieDBUtil {

    /**
     *
     */
    public static void deregisterDrivers() {
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static List<Movie> getMovieList() throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://localhost:3306/movies";
        String username = "root";
        String pass = "husky";
        ArrayList<Movie> movie = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Statement statement;
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(url,username,pass)) {
            statement = con.createStatement();
            rs = statement.executeQuery("select * from movieslist");
            while(rs.next()){
                String title = rs.getString("title");
                String director = rs.getString("director");
                String genre = rs.getString("genre");
                int rating = rs.getInt("rating");
                Movie m;
                m = new Movie(title,director,genre,rating);
                movie.add(m);
            }
        }     
        return movie;
    }    

    public static int addMovie(String title, String director, String genre, int rating)
        throws ClassNotFoundException, SQLException {
    String url = "jdbc:mysql://localhost:3306/movies";
    String username = "root";
    String pass = "husky";
    
    String sql = "INSERT INTO movieslist (title, director, genre, rating) VALUES (?, ?, ?, ?)";
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection con = DriverManager.getConnection(url, username, pass);
        PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setString(1, title);
        statement.setString(2, director);
        statement.setString(3, genre);
        statement.setInt(4, rating);
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0 ? 1 : 0; // Return 1 if rows were affected, otherwise 0
    } catch (SQLException e) {
        // Handle SQLException, log the error, and return 0 indicating failure
        e.printStackTrace();
        return 0;
    }
}

    


    
    public static Movie searchMovie(String inputText, String category) throws ClassNotFoundException, SQLException {
    String url = "jdbc:mysql://localhost:3306/movies";
    String username = "root";
    String pass = "husky";
    // Ensure that searchParam is a valid column name to prevent SQL injection
    String sql = "SELECT * FROM movieslist WHERE " + category+ " LIKE ? LIMIT 1";
    Movie searchedMovie = null;

    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection con = DriverManager.getConnection(url, username, pass);
         PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setString(1, inputText);

        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                String title = rs.getString("title");
                String director = rs.getString("director");
                String genre = rs.getString("genre");
                int rating = rs.getInt("rating");
                searchedMovie = new Movie(title, director, genre, rating);
            }
        }
    }
    return searchedMovie;
}

 
}
