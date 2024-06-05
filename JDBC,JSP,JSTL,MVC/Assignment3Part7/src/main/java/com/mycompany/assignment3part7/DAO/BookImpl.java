/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3part7.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookImpl {
    
    public int addBooks(List<String> isbn, List<String> title, List<String> authors, List<Float> price) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String pass = "husky";
        String sql = "INSERT INTO bookslist (isbn, title, authors, price) VALUES (?, ?, ?, ?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection con = DriverManager.getConnection(url, username, pass);
             PreparedStatement statement = con.prepareStatement(sql)) {
            
            for(int i = 0; i < isbn.size(); i++) {
                statement.setString(1, isbn.get(i));
                statement.setString(2, title.get(i));
                statement.setString(3, authors.get(i));
                statement.setFloat(4, price.get(i));
                
                statement.addBatch(); 
            }
            
            int[] rowsAffected = statement.executeBatch(); 
            
            int totalRowsAffected = 0;
            for (int row : rowsAffected) {
                totalRowsAffected += row;
            }
            System.out.println("totalRowsAffected"+ totalRowsAffected);
            return totalRowsAffected; 
        } catch (SQLException e) {
            return 0;
        }
    }
}
