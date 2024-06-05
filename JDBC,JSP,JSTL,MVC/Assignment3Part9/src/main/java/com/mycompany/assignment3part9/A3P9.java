/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3part9;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kamuni.saheeshna
 */
public class A3P9 extends SimpleTagSupport{

    private String nameCSV;

    public void setNameCSV(String nameCSV) {
        this.nameCSV = nameCSV;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            try (Connection connection = DriverManager.getConnection("jdbc:relique:csv:C:\\Users\\91773\\Desktop\\Spring2024\\WebTools\\Assignments\\Assignment2\\"); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameCSV)) {
                ResultSetMetaData set = resultSet.getMetaData();
                
                int tableC = set.getColumnCount();
                
                getJspContext().getOut().println("<table>");
                
                getJspContext().getOut().println("<tr>");
                for (int i = 1; i <= tableC; i++) {
                    getJspContext().getOut().println("<th>" + set.getColumnName(i) + "</th>");
                }
                getJspContext().getOut().println("</tr>");

                while (resultSet.next()) {
                    getJspContext().getOut().println("<tr>");
                    for (int i = 1; i <= tableC; i++) {
                        getJspContext().getOut().println("<td>" + resultSet.getString(i) + "</td>");
                    }
                    getJspContext().getOut().println("</tr>");
                    
                }
                getJspContext().getOut().println("</table>");
                // Close resources

            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
        }
    }
    
}

    

