package com.mycompany.assignment2p6.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kamuni.saheeshna
 */
@Controller
public class ShoppingCartController {
    
    private ArrayList<String> cart;
    
    public ShoppingCartController() {
        init();
    }
    
    private void init() {
        cart = new ArrayList<>();
    }
    
    @RequestMapping(value = "/ShoppingCart.htm", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        ArrayList<String> sessionCart = (ArrayList<String>) session.getAttribute("addcart");
        if (sessionCart != null) {
            cart = sessionCart;
        }

        String value = request.getParameter("click");

        switch (value) {
            case "addCart":
                String[] fullCart = request.getParameterValues("items");
                addToCart(fullCart);
                session.setAttribute("addcart", cart);
                return displayCart();
            case "viewCart":
                if (cart.isEmpty()) {
                    return displayEmptyCart();
                } else {
                    ModelAndView modelAndView = new ModelAndView("cartPage");
                    modelAndView.addObject("cart", cart);
                    return modelAndView;
                }
            case "remove":
                removeFromCart(request.getParameterValues("selectedItems"));
                session.setAttribute("addcart", cart);
                return displayCart();
            default:
                return new ModelAndView("errorPage"); 
        }
    }
    
    private void addToCart(String[] items) {
        if (items != null) {
            cart.addAll(Arrays.asList(items));
        }
    }
    
    private ModelAndView displayCart() {
        ModelAndView modelAndView = new ModelAndView("cartPage"); 
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    private void removeFromCart(String[] items) {
        if (items != null) {
            cart.removeAll(Arrays.asList(items));
        }
    }
    
    private ModelAndView displayEmptyCart() {
        ModelAndView modelAndView = new ModelAndView("cartPage");
        modelAndView.addObject("message", "Cart List is empty.");
        return modelAndView;
    }       
}
