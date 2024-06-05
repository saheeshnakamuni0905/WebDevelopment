/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.part7;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kamuni.saheeshna
 */
@WebServlet(name = "AddCart", urlPatterns = {"/AddCart.do"})
public class AddCart extends HttpServlet {

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
            HttpSession session = request.getSession();
            ArrayList<String> cart = (ArrayList<String>) session.getAttribute("addcart");
            if (cart == null) {
                cart = new ArrayList<>();
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Part_7</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Shopping Cart Values</h1>");
            out.println("<br/>");
            String value=request.getParameter("click");
            
            switch (value) {
                case "addCart":
                    String[] fullCart = request.getParameterValues("items");
                    if (fullCart != null) {
                        cart.addAll(Arrays.asList(fullCart));
                    }
                    out.println("Added to Cart Successfully" + "<br/>");
                    out.println("<h3>Items in Your Cart:</h3>");
                    if (cart.isEmpty()) {
                        out.println("<p>Your cart is empty.</p>");
                    } else {
                        out.println("<ul>");
                        for (String item : cart) {
                            out.println("<li>" + item + "</li>");
                        }
                        out.println("</ul>");
                    }
                    out.println("<a href='index.html'>Continue Shopping</a>");
                    session.setAttribute("addcart", cart);
                    break;
                case "viewCart":
                    if(cart.isEmpty()){
                        out.println("Cart List is empty. "+"<br/>");
                        out.println("<a href = 'index.html'>Continue Shopping</button>");
                    }else{
                        out.println("View Cart Values: "+ session.getAttribute("addcart")+ "<br/><br/>");                        
                        out.println("<form action='AddCart.do' method='post'>");
                        ArrayList<String> items = (ArrayList<String>) session.getAttribute("addcart");
                        for(int i=0; i< items.size() ;i++){
                            out.println("<input type='checkbox' id='const' name='rCart' value="+items.get(i)+">");
                            out.println("<label for='const'>"+ items.get(i)+"</label><br/><br/>");   
                        }
                        out.println("<button name='click' value='remove'>Remove</button>"+ "<br/><br/>");
                        out.println("<a href ='index.html'>Continue Shopping</button>"); 
                    }
                    break;
                case "remove":
                    ArrayList<String> sessionCart = (ArrayList<String>) session.getAttribute("addcart");
                    if (sessionCart != null) {
                        String[] rCartValues = request.getParameterValues("rCart");
                        if (rCartValues != null) {
                            for (String val : rCartValues) {
                                sessionCart.remove(val);
                            }
                        session.setAttribute("addcart", sessionCart);
                        out.println("Items removed successfully.<br/>");
                    } else {
                        out.println("No items were selected for removal.<br/>");
                    }} else {
                        out.println("Your cart is empty.<br/>");
                    }

                    out.println("<h3>Items in Your Cart:</h3>");
                    if (sessionCart == null || sessionCart.isEmpty()) {
                        out.println("<p>Your cart is empty.</p>");
                    } else {
                    out.println("<ul>");
                    for (String item : sessionCart) {
                        out.println("<li>" + item + "</li>");
                    }
                    out.println("</ul>");
                    }
                out.println("<a href='index.html'>Continue Shopping</a>");
                break;
                default:
                    break;
            }
            out.println("</body>");
            out.println("</html>");
            request.logout();
            out.close();
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
