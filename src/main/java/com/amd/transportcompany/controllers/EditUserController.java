/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.User;
import com.amd.transportcompany.forms.EditUserForm;
import com.amd.transportcompany.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author a
 */
@Controller
public class EditUserController {
 
    @Autowired
    private UserService userService;
    
    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/edituser", method = RequestMethod.GET)        
    public ModelAndView editUser(@RequestParam("user")String username, ModelAndView model) {
        
        User user = userService.findByName(username);
        EditUserForm editUserForm = new EditUserForm(user);
        model.setViewName("edituser");
        model.addObject("editUserForm", editUserForm);
        return model;
    }
   
    
    
    @RequestMapping(value = "/edituser",method = RequestMethod.POST)
    public ModelAndView useradded(@Valid final EditUserForm editUserForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors() ||  
                    ! editUserForm.getPassword().equals(editUserForm.getConfirmPassword())) {
            
            return model;
	}
        
        User user = userService.findByName(editUserForm.getUsername());
        
        user.setDisabled(editUserForm.isDisabled());
        if(user.isDisabled()){
            user.setCar(null);
        }
        
        user.setUsername(editUserForm.getUsername());
        
        user.setFirstname(editUserForm.getFirstname());
        user.setLastname(editUserForm.getLastname());
        user.setPhone(editUserForm.getPhone());
        user.setUserRole(editUserForm.getRole());
        if( ! editUserForm.getPassword().isEmpty() && editUserForm.getPassword().equals(
                editUserForm.getConfirmPassword()) ){
            user.setPassword(passwordEncoder.encodePassword(editUserForm.getPassword(), user.getUsername()));
        }

        userService.saveUser(user);
        
        model.setViewName("message");
        model.addObject("message", "saved");
        return model;
    }
     
}
