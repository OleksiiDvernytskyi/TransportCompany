/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.Order;
import com.amd.transportcompany.entities.OrderStatus;
import com.amd.transportcompany.entities.User;
import com.amd.transportcompany.entities.UserRole;
import com.amd.transportcompany.forms.EditOrderForm;
import com.amd.transportcompany.services.OrderService;
import com.amd.transportcompany.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class EditOrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/editorder", method = RequestMethod.GET)        
    public ModelAndView editOrder(@RequestParam(value ="o", required = false)Long orderId, ModelAndView model) {
        
        if(orderId == null ){
            orderId = 0L;
        }
        Order order = orderService.findById(orderId);
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        User user = userService.findByName(username);
        if(user.getUserRole() == UserRole.DRIVER){
           List<Order> orderList =  orderService.getActiveOrdersByUserID(user.getUserId());
           
           if(orderList.isEmpty()){
               model.setViewName("message");
               model.addObject("message", "no_orders");
               
               return model;
           }
           order =orderList.get(0);
           
        } else{
            if(order == null){
                model.setViewName("error");
                model.addObject("message", "Order #" + orderId+ " not found");
                
                return model;
            }
            List<User> drivers = userService.getActiveDrivers(order.getPassengers(), order.getCarCategory());

            model.addObject("order", order);
            model.addObject("drivers", drivers);
        }    
        
        EditOrderForm editOrderForm = new EditOrderForm(order);
        
        model.setViewName("editorder");
        model.addObject("editOrderForm", editOrderForm);
        
         
        return model;
    }
    
    @RequestMapping(value = "/editorder",method = RequestMethod.POST)
    public ModelAndView editComplete(@Valid final EditOrderForm editOrderForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors() ){
            return model;
        }   
            Order order = orderService.findById(editOrderForm.getOrderId());
            
            if(editOrderForm.isComplete()){
                orderService.setStatus(order, OrderStatus.CANCELED);
                
                model.setViewName("message");
                model.addObject("message", "archived");
                return model;
                
            }
        
            if(editOrderForm.isCanceled() && (order.getStatus().equals(OrderStatus.NEW) ||
                    order.getStatus().equals(OrderStatus.ACTIVE))){
                    orderService.setStatus(order, OrderStatus.CANCELED);
                    
                model.setViewName("message");
                model.addObject("message", "canceled");
                return model;
            }
            if(editOrderForm.getDriverId() !=null && editOrderForm.getDriverId() != 0 ){
                orderService.setDriver(order,editOrderForm.getDriverId());
            }
            
            model.setViewName("message");
            model.addObject("message", "changed");
        
            return model;  
	}
}
