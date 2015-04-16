/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class ViewOrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping(value = "/vieworder", method = RequestMethod.GET)
	public ModelAndView signinFailure(@RequestParam( "o")Long orderId, ModelAndView model) {
            Order order = orderService.findById(orderId);  
            if(order  == null){
                model.addObject("message", "incorr_numb");
                model.setViewName("error");
                return model;
            }
            
            model.addObject("order", order);
            model.setViewName("vieworder");
            return model;
	}
}
