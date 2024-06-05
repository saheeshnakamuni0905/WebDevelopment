package com.mycompany.assignment4part5.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mycompany.assignment4part5.pojo.MovieData;
import java.sql.ResultSet;

public class MovieDAOImpl implements MovieDAO {

    private final DataSource dataSource;

    public MovieDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addMovie(String title, String director, String genre, int rating) {
        String sql = "INSERT INTO movieslist (title, director, genre, rating) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, director);
            statement.setString(3, genre);
            statement.setInt(4, rating);
            return statement.executeUpdate();
        } catch (SQLException e) {}
        return 0;
    }
    
    @Override
    public MovieData searchMovie(String inputText, String category) {
        String sql = "SELECT * FROM movieslist WHERE " + category + " = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inputText);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String director = resultSet.getString("director");
                    String genre = resultSet.getString("genre");
                    int rating = resultSet.getInt("rating");
                    return new MovieData(title, director, genre, rating);
                }
            }
        } catch (SQLException e) {}
        return null;
    }
}
