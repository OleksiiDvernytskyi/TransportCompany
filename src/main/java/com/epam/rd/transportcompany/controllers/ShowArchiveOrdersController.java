/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.forms.OrderSearchForm;
import com.epam.rd.transportcompany.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class ShowArchiveOrdersController {
    
    @Autowired
    private OrderService orderService;
    
    @ModelAttribute("orderSearchForm")
    public OrderSearchForm constructForm() {
    return new OrderSearchForm();
    }
    
    @RequestMapping(value = "showarchiveorders", method = RequestMethod.GET )        
    public ModelAndView showArchiveOrders(@RequestParam (value = "p", required = false) Integer pageNumber, ModelAndView model) {
      
    if(pageNumber ==null ){
        pageNumber = 0;
    }
    if(pageNumber< 0){
        pageNumber =0;
    }
        
    List<Order> orderList = orderService.getArchiveOrders(pageNumber);
       
    if( pageNumber !=0 && orderList.isEmpty()){
        orderList = orderService.getArchiveOrders(--pageNumber);
    }
        
        
    model.addObject("pageNumber", pageNumber);
    model.addObject("orderList", orderList);
    model.setViewName("showarchiveorders");
    return model;
    }
}
