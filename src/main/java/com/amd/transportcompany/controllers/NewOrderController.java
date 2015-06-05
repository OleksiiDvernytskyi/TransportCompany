/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.Order;
import com.amd.transportcompany.forms.NewOrderForm;
import com.amd.transportcompany.services.OrderService;
import com.amd.transportcompany.services.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
    
    @Autowired
    private UserService userService;
    
    @ModelAttribute("newOrderForm")
    public NewOrderForm construct() {
    return new NewOrderForm();
    }

    @RequestMapping(value = "addorder", method = RequestMethod.GET)        
    public ModelAndView addOrder(ModelAndView model) {
            
        return model;
    }
   
    @RequestMapping(value = "addorder",method = RequestMethod.POST)
    public ModelAndView orderAdded(@Valid final NewOrderForm newOrderForm, final BindingResult result, HttpServletResponse res, ModelAndView model) throws IOException {
	if (result.hasErrors()) {
            return model;
	}
        Order order = new Order();
        order.setPhone(newOrderForm.getPhone());
        order.setFromWhere(newOrderForm.getFromWhere());
        order.setToWhere(newOrderForm.getToWhere());
        order.setPassengers(newOrderForm.getPassengers());
        order.setCarCategory(newOrderForm.getCarCategory());
        
        orderService.saveOrder(order);
        
        if(order.getOrderId() != null){
            
            res.sendRedirect("editorder.html?o="+order.getOrderId());
            return null;
        }else{ 
            model.setViewName("error");
            model.addObject("message", "order_not");
        }
        
        return model;
        
    }
}
