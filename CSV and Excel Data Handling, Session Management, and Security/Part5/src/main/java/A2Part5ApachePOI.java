/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author kamuni.saheeshna
 */

@WebServlet(name="A2Part5ApachePOI", urlPatterns={"/apachepoi.xls"})
public class A2Part5ApachePOI extends HttpServlet {

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
        String fileName = request.getParameter("fileName");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet A2Part5ApachePOI</title>");            
            out.println("</head>");
            out.println("<body>");
           
            File storeFile = new File("C:/Users/91773/Desktop/Spring2024/WebTools/Assignments/Assignment2/" + fileName);
            FileInputStream stream = new FileInputStream(storeFile);
            HSSFWorkbook wbook = new HSSFWorkbook(stream);

        for (int i = 0; i < wbook.getNumberOfSheets(); i++) {
            HSSFSheet sh = wbook.getSheetAt(i);
            out.println("<table>");
            for (int j = 0; j < sh.getLastRowNum(); j++) {
                HSSFRow row = sh.getRow(j);
                out.println("<tr>");
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    HSSFCell cell = row.getCell(k);
                    String value = cell.toString();
                    if (j == 0) {
                        out.println(" <th> " + value);
                    } else {
                        out.println("<td>" + value);
                    }
                }
            }
            out.println("</table>");
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
        processRequest(request, response);
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
