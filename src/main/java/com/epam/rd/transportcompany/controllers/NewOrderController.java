/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.forms.NewOrderForm;
import com.epam.rd.transportcompany.services.OrderService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class NewOrderController {
    
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;
    
    @ModelAttribute("newOrder")
    public Order construct() {
    return new Order();
 }
    
    @RequestMapping(value = "/addorder", method = RequestMethod.GET)        
    public ModelAndView addOrder(ModelAndView model) {

        return model;
    }
   
    @RequestMapping(value = "/addorder",method = RequestMethod.POST)
    public ModelAndView orderAdded(@Valid final NewOrderForm newOrderForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors()) {
            return model;
	}
        Order order = new Order();
        order.setPhone(newOrderForm.getPhone());
        order.setFromWhere(newOrderForm.getFromWhere());
        order.setToWhere(newOrderForm.getToWhere());
        order.setPassengers(newOrderForm.getPassengers());
        order.setCargo(newOrderForm.getCargo());
        
        orderService.saveOrder(order);
        if(order.getOrderId() != null){
            model.setViewName("orderadded");
            model.addObject("newOrder", order);
        }else{ 
            model.setViewName("error");
            model.addObject("message", "Order not added, something goes wrong");
        }
        
        return model;
        
    }
}
