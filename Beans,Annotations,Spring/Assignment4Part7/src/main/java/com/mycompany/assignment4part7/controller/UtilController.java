/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part7.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kamuni.saheeshna
 */
public class UtilController extends AbstractController {
    
    public UtilController() {}
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BeanUtility utilService = (BeanUtility) this.getApplicationContext().getBean("utilitystr");
        
        request.setAttribute("message", utilService.getMessage());
        request.setAttribute("objectId", utilService);
        return new ModelAndView("text_message");
        
    }
    
}
