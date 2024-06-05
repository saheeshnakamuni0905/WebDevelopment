/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part9.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author kamuni.saheeshna
 */

@RequestScope
public class UtilClass {
    
    @Bean
    public String displayMessage(){
        return "Hello from Part9 Utility Class ";
    }
}
