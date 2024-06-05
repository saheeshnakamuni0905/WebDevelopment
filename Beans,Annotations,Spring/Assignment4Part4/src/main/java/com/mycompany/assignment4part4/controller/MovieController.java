package com.mycompany.assignment4part4.controller;

import com.mycompany.assignment4part4.DAO.MovieDAO;
import com.mycompany.assignment4part4.DAO.MovieDAOImpl;
import com.mycompany.assignment4part4.pojo.Movie;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller to handle adding and searching for movies.
 */
public class MovieController extends AbstractController {

    private final MovieDAO movieDAO;

    public MovieController() {
        DataSource dataSource = getDataSource();
        movieDAO = new MovieDAOImpl(dataSource);
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/movies");
        dataSource.setUsername("root");
        dataSource.setPassword("husky");
        return dataSource;
    }

    @Bean
    public MovieDAO getContactDAO() {
        return new MovieDAOImpl(getDataSource());
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String action = request.getParameter("action");

        try {
            switch (action.toLowerCase()) {
                case "add_movie":
                    modelAndView.setViewName("add_movies");
                    break;
                case "search_movie":
                    modelAndView.setViewName("browse_movies");
                    break;
                case "submit_add":
                    processAddMovie(request, modelAndView);
                    break;
                case "submit_browse":
                    processSearchMovie(request, modelAndView);
                    break;
                default:
                    modelAndView.setViewName("index");
                    break;
            }
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    private void processAddMovie(HttpServletRequest request, ModelAndView modelAndView) throws NumberFormatException, ClassNotFoundException, SQLException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String genre = request.getParameter("genre");
        int rating = Integer.parseInt(request.getParameter("rating"));

        int result = movieDAO.addMovie(title, director, genre, rating);
        if (result == 1) {
            modelAndView.setViewName("movie_added");
        } else {
            modelAndView.setViewName("movie_notadded");
        }
    }

    private void processSearchMovie(HttpServletRequest request, ModelAndView modelAndView) {
        String inputText = request.getParameter("inputText");
        String category = request.getParameter("category");

        try {
            Movie searchedMovie = movieDAO.searchMovie(inputText, category);
            if (searchedMovie != null) {
                modelAndView.addObject("searchedMovie", searchedMovie);
                modelAndView.setViewName("movie_search");
            } else {
                modelAndView.setViewName("movie_notFound");
            }
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
            modelAndView.setViewName("error");
        }
    }
}
