/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.forms.NewUserForm;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
public class NewUserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ShaPasswordEncoder passwordEncoder;
    
    @ModelAttribute("newUserForm")
    public NewUserForm constructForm() {
    return new NewUserForm();
    }
    
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)        
    public String addUser(ModelMap model) {
        
        return "adduser";
    }
   
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public ModelAndView useradded(@Valid final NewUserForm newUserForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors()) {
            return model;
	}
        
        if(userService.findByName(newUserForm.getUsername().trim()) != null ){
            result.rejectValue("username", "error.newUserForm", "Username already exists");
            return model;
        }
        
        User newUser = new User();

        newUser.setUsername(newUserForm.getUsername());
        newUser.setFirstName(newUserForm.getFirstname());
        newUser.setLastName(newUserForm.getLastname());
        newUser.setPhone(newUserForm.getPhone());
        newUser.setUserRole(newUserForm.getRole());
       
        newUser.setPassword(passwordEncoder.encodePassword(newUserForm.getPassword(), newUser.getUsername()));
      
        if(userService.saveUser(newUser) != null){
            model.setViewName("useradded");
            model.addObject("newUser", newUser);
        }else{
            model.setViewName("error");
            model.addObject("message", "User not added, something goes wrong");
        }
        return model;
    }
          
}
