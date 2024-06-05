/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.assignment4part5.DAO;

import com.mycompany.assignment4part5.pojo.MovieData;
import java.sql.SQLException;

/**
 *
 * @author kamuni.saheeshna
 */
public interface MovieDAO {
    
    int addMovie(String title, String director, String genre, int rating) throws ClassNotFoundException, SQLException;
    MovieData searchMovie(String inputText, String category) throws ClassNotFoundException, SQLException;
     
}
