/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.User;
import com.amd.transportcompany.forms.UserSearchForm;
import com.amd.transportcompany.services.UserService;
import java.util.ArrayList;
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
 * @author a
 */
@Controller
public class ShowUsersController {
    
    @Autowired
    private UserService userService;
     
     @ModelAttribute("userSearchForm")
    public UserSearchForm constructForm() {
    return new UserSearchForm();
    }
    
    @RequestMapping(value = "/showusers", method = RequestMethod.GET)        
    public ModelAndView showUsers(@RequestParam (value ="p", required = false) Integer pageNumber, ModelAndView model) {
        
        if(pageNumber ==null || pageNumber< 1 ){
            pageNumber = 1;
        }
        
        Long pagesCount = userService.getPagesCount()+1;
        
        if(pageNumber > pagesCount )
            pageNumber= pagesCount.intValue();
        
        List<User> userList = userService.getAllUsers(pageNumber);
       
        model.addObject("pagesCount", pagesCount);
        model.addObject("pageNumber", pageNumber);
        model.addObject("userList", userList);
        model.setViewName("showusers");
        return model;
    }
    
    @RequestMapping(value = "/showusers", method = RequestMethod.POST)        
    public ModelAndView searchUser(@Valid final UserSearchForm userSearchForm, final BindingResult result, ModelAndView model) {
        
        if(userSearchForm.getUsername().isEmpty()){
            showUsers(0, model);
            return model;
        }
        
        List<User> userList = new ArrayList();
        userList.add(userService.findByName(userSearchForm.getUsername()));
        model.addObject("userList", userList);
        model.setViewName("showusers");
        return model;
    }
}
