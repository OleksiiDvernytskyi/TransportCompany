/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.OrderStatus;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import com.epam.rd.transportcompany.forms.EditOrderForm;
import com.epam.rd.transportcompany.services.OrderService;
import com.epam.rd.transportcompany.services.UserService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)        
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
               model.addObject("message", "You have no orders");
               
               return model;
           }
           order =orderList.get(0);
           
        } else{
            if(order == null){
                model.setViewName("error");
                model.addObject("message", "Order #" + orderId+ " not found");
                
                return model;
            }
            List<User> drivers = userService.getActiveDrivers(order.getPassengers(), order.getCargo());
            Map<Long,String> carMap = new LinkedHashMap();
            if(order.getDriver() == null){
                for(User u: drivers){
                    carMap.put(u.getUserId(), u.getCar().getCarModel());
                    System.out.println("u " + u.getUserId() + " " + u.getCar().getCarModel());
                }
            }
            model.addObject("carMap",carMap);
        }    
        
        EditOrderForm editOrderForm = new EditOrderForm(order);
        model.setViewName("editOrder");
        model.addObject("editOrderForm", editOrderForm);
        
         
        return model;
    }
    
    @RequestMapping(value = "/editOrder",method = RequestMethod.POST)
    public ModelAndView editComplite(@Valid final EditOrderForm editOrderForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors() ){
            return model;
        }   
            Order order = orderService.findById(editOrderForm.getOrderId());
            
            if(editOrderForm.isComplite()){
                orderService.setStatus(order, OrderStatus.CANCELED);
                
                model.setViewName("message");
                model.addObject("message", "Order #" + order.getOrderId() + " sent to archive");
                return model;
                
            }
        
            if(editOrderForm.isCanceled() && (order.getStatus().equals(OrderStatus.NEW) ||
                    order.getStatus().equals(OrderStatus.ACTIVE))){
                    orderService.setStatus(order, OrderStatus.CANCELED);
                    
                model.setViewName("message");
                model.addObject("message", "Order #" + editOrderForm.getOrderId() + " canceled");
                return model;
            }
            if(editOrderForm.getDriverId() != 0 ){
                orderService.setDriver(order,editOrderForm.getDriverId());
            }
            
            model.setViewName("message");
            model.addObject("message", "Changed successfully");
        
            return model;  
	}
}
