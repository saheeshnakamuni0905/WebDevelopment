package com.mycompany.assignment3part6.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import com.mycompany.assignment3part6.pojo.Movie;
import com.mycompany.assignment6part3.DAO.MovieDBUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamuni.saheeshna
 */
public class MovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action.equalsIgnoreCase("addingMovie")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/addnewmovie.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                System.out.println(ex);
            }

        } else if (action.equalsIgnoreCase("searchMovie")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/browse_movies.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                System.out.println(ex);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    String action = request.getParameter("action");
       
    if(action.equalsIgnoreCase("addingMovie")){
       
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String genre = request.getParameter("genre");
        int rating = Integer.parseInt(request.getParameter("rating"));

        try {
            int result = MovieDBUtil.addMovie(title, director, genre, rating);
            if (result == 1) {
                Movie movieData = new Movie( title, director, genre, rating);
                
                request.setAttribute("movieData", Collections.singletonList(movieData));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MovieAddedSuccess.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MovieNotAdded.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MovieServlet.class.getName()).log(Level.SEVERE, null, ex);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
        } else if (action.equalsIgnoreCase("searchMovie")) {
            String inputText = request.getParameter("inputText");
            String category = request.getParameter("category");
 
            try {
                Movie searchedMovie = MovieDBUtil.searchMovie(inputText, category);

                if(searchedMovie == null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/NotFoundMovie.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    request.setAttribute("searchedMovie", searchedMovie);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MovieSearchedSuccess.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MovieServlet.class.getName()).log(Level.SEVERE, null, ex);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                requestDispatcher.forward(request, response);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
