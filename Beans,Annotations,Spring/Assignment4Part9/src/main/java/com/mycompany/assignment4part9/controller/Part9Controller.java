/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part9.controller;

import com.mycompany.assignment4part9.utility.UtilClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kamuni.saheeshna
 */
@Controller
public class Part9Controller {
    
    public Part9Controller() {}
    
    @GetMapping("/displayMessage.htm")
    public String handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response, UtilClass utiClass) throws Exception {
        request.setAttribute("message", utiClass.displayMessage());
        request.setAttribute("objectId", utiClass);
        return "displayMessage"; 
    }  
    
}
