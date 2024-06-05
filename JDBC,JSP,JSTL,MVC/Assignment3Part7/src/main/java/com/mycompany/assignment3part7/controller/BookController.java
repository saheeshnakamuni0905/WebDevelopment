/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.assignment3part7.controller;

import com.mycompany.assignment3part7.DAO.BookImpl;
import com.mycompany.assignment3part7.pojo.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamuni.saheeshna
 */
@WebServlet(name = "BookController", urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    RequestDispatcher requestDispatcher;
    
    String value = request.getParameter("someVal");
    int intValue = Integer.parseInt(value);
    ArrayList<String> isbn = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<Float> price = new ArrayList<>();

    try {
        for (int i = 0; i < intValue; i++) {
            isbn.add(request.getParameter("isbn" + i));
            title.add(request.getParameter("title" + i));
            authors.add(request.getParameter("authors" + i));
            price.add(Float.valueOf(request.getParameter("price" + i))); // Changed to parseFloat
        }

        BookImpl bookObj = new BookImpl();
        int result = 0;
        try {
            result = bookObj.addBooks(isbn, title, authors, price);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (result > 0) {
            request.setAttribute("count", intValue);
            requestDispatcher = getServletContext().getRequestDispatcher("/InsertedSuccessful.jsp");
            requestDispatcher.forward(request, response);
        } else {
            requestDispatcher = getServletContext().getRequestDispatcher("/InsertFailed.jsp");
        }
    }catch (NumberFormatException e) {
        // Handle parsing errors
        requestDispatcher = getServletContext().getRequestDispatcher("/InsertFailed.jsp");
        requestDispatcher.forward(request, response);
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
