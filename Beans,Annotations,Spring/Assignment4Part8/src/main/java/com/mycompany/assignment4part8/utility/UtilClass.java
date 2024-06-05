/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4part8.utility;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author kamuni.saheeshna
 */

@Configuration
public class UtilClass {
    
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    @Bean
    public String displayMessage() {
        return "Hello from Part 8 Utility Class. Code By Saheeshna Kamuni";
    }
    
}
