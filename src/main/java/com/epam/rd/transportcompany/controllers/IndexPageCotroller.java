/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.forms.LoginForm;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class IndexPageCotroller {

    @ModelAttribute("userRole")
    public String userRole() {
    return  ""+SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        String role = auth.getAuthorities().toString();
        if (auth.isAuthenticated() && !name.equals("anonymousUser")){
            model.setViewName("welcome");
            model.addObject("username", name);
            model.addObject("role", role);
        }
        
        return model;
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView login(@Valid final LoginForm loginForm, final BindingResult result,ModelAndView model ){
    if (result.hasErrors()) {
            return model;
	}
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (auth.isAuthenticated()&& !name.equals("anonymousUser")){
          model.addObject("username", name);
          model.setViewName("welcome");
        }
        
        return model;
    }
    
    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public ModelAndView signinFailure(ModelAndView model) {
		model.addObject("message", "Incorrect login or password");
                model.setViewName("error");
                return model;
	}
}
