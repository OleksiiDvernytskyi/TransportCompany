/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.Car;
import com.amd.transportcompany.entities.Order;
import com.amd.transportcompany.entities.User;
import com.amd.transportcompany.forms.EditProfileForm;
import com.amd.transportcompany.services.CarService;
import com.amd.transportcompany.services.OrderService;
import com.amd.transportcompany.services.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class UserProfileController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ShaPasswordEncoder passwordEncoder;
    
    @RequestMapping(value = "/userprofile", method = RequestMethod.GET)        
    public ModelAndView editUser( ModelAndView model) {
        
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        User user = userService.findByName(username);
        EditProfileForm editProfileForm = new EditProfileForm(user);
        
        List<Car> carList = carService.readAll();

        model.addObject("carList",carList);
        
        model.setViewName("userprofile");
        model.addObject("editProfileForm", editProfileForm);
        return model;
    }
    
    @RequestMapping(value = "/userprofile",method = RequestMethod.POST)
    public ModelAndView useradded(@Valid final EditProfileForm editProfileForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors() || 
                    ! editProfileForm.getPassword().equals(editProfileForm.getConfirmPassword())) {
            
            return model;
	}
        
        User user = userService.findByName(editProfileForm.getUsername());
        
        user.setPhone(editProfileForm.getPhone());
        
        if( ! editProfileForm.getPassword().isEmpty() && editProfileForm.getPassword().equals(
                editProfileForm.getConfirmPassword()) ){
            user.setPassword(passwordEncoder.encodePassword(editProfileForm.getPassword(), user.getUsername()));
        }
        
        if(editProfileForm.getCarId() !=null && editProfileForm.getCarId() != 0 ){
            Car car = carService.findById(editProfileForm.getCarId());
            user.setCar(car);
        }
        List<Order> order = orderService.getActiveOrdersByUserID(user.getUserId()); 
        
        if(user.getCar() !=null && order.isEmpty() ){
            user.setReady(editProfileForm.isReady());
        }
        
        userService.saveUser(user);
        
        model.setViewName("message");
        model.addObject("message", "changed");
        return model;
    }
}
