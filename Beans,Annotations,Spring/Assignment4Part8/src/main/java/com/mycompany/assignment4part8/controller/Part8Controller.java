/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part8.controller;

import com.mycompany.assignment4part8.utility.UtilClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kamuni.saheeshna
 */
@Controller
public class Part8Controller {
    
    @Autowired
    UtilClass utilClass;
    
    public Part8Controller() {}
    
    @GetMapping("/displayMssge.htm")
    public String handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.setAttribute("message", utilClass.displayMessage());
        request.setAttribute("objectId", utilClass);
        return "displayMssge";
        
    }
   }

    

