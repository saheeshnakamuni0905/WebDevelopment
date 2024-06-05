/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.part4;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamuni.saheeshna
 */
public class ReadCSVFile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String csvDirectory = "C:\\Users\\91773\\Desktop\\Spring2024\\WebTools\\Assignments\\Assignment2\\";
        String csvFileName = request.getParameter("fileName");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReadCSVFile</title>");            
            out.println("</head>");
            out.println("<body>");
     
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
                try (Connection connection = DriverManager.getConnection("jdbc:relique:csv:" + csvDirectory); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ csvFileName)) {
                    
                    out.println("<html><head><title>CSV Data</title></head><body>");
                    out.println("<table border='1'>");
                    
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    out.println("<tr>");
                    for (int i = 1; i <= columnCount; i++) {
                        out.println("<th>" + resultSet.getMetaData().getColumnName(i) + "</th>");
                    }
                    out.println("</tr>");
                    
                    // Retrieve and display data rows
                    while (resultSet.next()) {
                        out.println("<tr>");
                        for (int i = 1; i <= columnCount; i++) {
                            out.println("<td>" + resultSet.getString(i) + "</td>");
                        }
                        out.println("</tr>");
                    }
                    
                    out.println("</table></body></html>");
             
            }
        } catch (ClassNotFoundException e) {
            out.println("Error: " + e.getMessage());
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadCSVFile.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadCSVFile.class.getName()).log(Level.SEVERE, null, ex);
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
