/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Car;
import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.forms.EditProfileForm;
import com.epam.rd.transportcompany.services.CarService;
import com.epam.rd.transportcompany.services.OrderService;
import com.epam.rd.transportcompany.services.UserService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        if(user.getCar() != null) {
            model.addObject("userCar", user.getCar().getCarModel());
        }
        
        List<Car> carList = carService.readAll();
        
        Map<Long,String> carMap = new LinkedHashMap();
        for(Car car: carList){
            carMap.put(car.getCarId(), car.getCarModel());
        }
        
        model.addObject("carMap",carMap);
        
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
        model.addObject("message", "Changed successfully");
        return model;
    }
}
