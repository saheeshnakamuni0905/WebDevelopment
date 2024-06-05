/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part4.DAO;

import com.mycompany.assignment4part4.pojo.Movie;
import java.sql.SQLException;

/**
 *
 * @author kamuni.saheeshna
 */

public interface MovieDAO {
    int addMovie(String title, String director, String genre, int rating) throws ClassNotFoundException, SQLException;
    Movie searchMovie(String inputText, String category) throws ClassNotFoundException, SQLException;
      

}
