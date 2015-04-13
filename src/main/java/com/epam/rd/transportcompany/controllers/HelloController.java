/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author amd
 */
@Controller

public class HelloController {
    
    public HelloController() {

    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String printHello(ModelMap model){
        
        
        model.addAttribute("message", "Hello Spring!!!!!");
        return "hello";
    }

}
