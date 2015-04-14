/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.OrderStatus;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.forms.EditOrderForm;
import com.epam.rd.transportcompany.services.OrderService;
import com.epam.rd.transportcompany.services.UserService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
public class EditOrderController {
    
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;
    
    @Autowired
    private UserService userService;
//    
//    @ModelAttribute("editOrderForm")
//    public EditOrderForm constructForm() {
//    return new EditOrderForm();
//    }
    
    @RequestMapping(value = "/editorder", method = RequestMethod.GET)        
    public ModelAndView editOrder(@RequestParam(value ="o")Long orderId, ModelAndView model) {
        
        
        Order order = orderService.findById(orderId);
        List<User> drivers = userService.getActiveDrivers(order.getPassengers(), order.getCargo() );
        Map<Long,String> carMap = new LinkedHashMap();
        if(order.getDriver() !=null){
            for(User u: drivers){
                carMap.put(u.getUserId(), u.getCar().getCarModel());
            }
        }
        model.addObject("carMap",carMap);
        
        EditOrderForm editOrderForm = new EditOrderForm(order);
        model.setViewName("editorder");
        model.addObject("editOrderForm", editOrderForm);
        
         
        return model;
    }
    
    @RequestMapping(value = "/editorder",method = RequestMethod.POST)
    public ModelAndView editComplite(@Valid final EditOrderForm editOrderForm, final BindingResult result, ModelAndView model) {
//	if (result.hasErrors() ){
//            return model;
//        }
        
            Order order = orderService.findById(editOrderForm.getOrderId());
            if(editOrderForm.isCanceled() && (order.getStatus().equals(OrderStatus.NEW) ||
                    order.getStatus().equals(OrderStatus.ACTIVE))){
                    orderService.setStatus(order, OrderStatus.CANCELED);
                    
                model.setViewName("index");
                return model;
            }
            
            orderService.setDriver(order,editOrderForm.getDriverId());
            
                
            return model;  
	}
}
