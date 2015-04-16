/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.forms.OrderSearchForm;
import com.epam.rd.transportcompany.services.OrderService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ShowActiveOrdersController {
    
    @Autowired
    private OrderService orderService;
    
//    @ModelAttribute("orderSearchForm")
//    public OrderSearchForm constructForm() {
//    return new OrderSearchForm();
//    }
    OrderSearchForm orderSearchForm = new OrderSearchForm();
    @RequestMapping(value = "showactiveorders", method = RequestMethod.GET)        
    public ModelAndView showActiveOrders(@RequestParam (value ="p", required = false) Integer pageNumber, 
            @RequestParam (value ="ph", required = false) String phone, ModelAndView model) {
        
        if(pageNumber ==null || pageNumber< 1 ){
            pageNumber = 1;
        }
      
        if(phone == null || phone.length()<3)
            phone="";
        
        orderSearchForm.setPhone(phone);
        List<Order> orderList = orderService.getActiveOrders(pageNumber, phone);
       
        Long pagesCount = orderService.getActivePagesCount(phone)+1;
        
        if( pageNumber >1 && orderList.isEmpty()){
            orderList = orderService.getActiveOrders(--pageNumber, phone);
        }
        model.addObject("pagesCount", pagesCount);
        model.addObject("phone",phone );
        model.addObject("orderSearchForm", orderSearchForm);
        model.addObject("pageNumber", pageNumber);
        model.addObject("orderList", orderList);
        model.setViewName("showactiveorders");
        return model;
    }
    
    
    @RequestMapping(value = "showactiveorders", method = RequestMethod.POST)        
    public ModelAndView searchUser(@RequestParam (value ="p", required = false) Integer pageNumber,
            @Valid final OrderSearchForm orderSearchForm, final BindingResult result, ModelAndView model) {
        
        if(orderSearchForm.getPhone().length() < 3){
            showActiveOrders(1, "", model);
            return model;
        }
        
        if(pageNumber ==null || pageNumber< 1 ){
            pageNumber = 1;
        }
        
        List<Order> orderList = orderService.getActiveOrders(pageNumber, orderSearchForm.getPhone());
        if( pageNumber >1 && orderList.isEmpty()){
            orderList = orderService.getActiveOrders(--pageNumber, orderSearchForm.getPhone());
        }
        Long pagesCount = orderService.getActivePagesCount(orderSearchForm.getPhone())+1;
        
        for(Order o: orderList){
            if(o.getDriver() == null){
                o.setDriver(new User());
                
            }
        }
        
        if(orderSearchForm.getPhone() !=null && orderSearchForm.getPhone().length() >= 3)
            model.addObject("phone",orderSearchForm.getPhone() );
        model.addObject("pageNumber", pageNumber);
        model.addObject("pagesCount", pagesCount);
        model.addObject("orderList", orderList);
        model.setViewName("showactiveorders");
        return model;
    }
}
