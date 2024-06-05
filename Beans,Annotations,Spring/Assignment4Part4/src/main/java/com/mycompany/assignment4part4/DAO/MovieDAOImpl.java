
package com.mycompany.assignment4part4.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mycompany.assignment4part4.pojo.Movie;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kamuni.saheeshna
 */

public class MovieDAOImpl implements MovieDAO {

    private final DataSource dataSource;

    public MovieDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addMovie(String title, String director, String genre, int rating) {
        String sql = "INSERT INTO movieslist (title, director, genre, rating) VALUES ('" + title + "', '" + director + "', '" + genre + "', " + rating + ")";
        try (Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {}
        return 0;
    }
    
    @Override
    public Movie searchMovie(String inputText, String category) {
        String sql = "SELECT * FROM movieslist WHERE " + category + " = '" + inputText + "'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                String genre = resultSet.getString("genre");
                int rating = resultSet.getInt("rating");
                return new Movie(title, director, genre, rating);
            }
        } catch (SQLException e) {}
        return null;
    }
}
