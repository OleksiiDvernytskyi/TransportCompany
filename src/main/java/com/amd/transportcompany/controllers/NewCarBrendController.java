/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.CarBrend;
import com.amd.transportcompany.forms.NewCarBrendForm;
import com.amd.transportcompany.services.CarBrendService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class NewCarBrendController {
    
    @Autowired
    @Qualifier("carBrendService")
    private CarBrendService carBrendService;
    
    @ModelAttribute("newCarBrendForm")
    public NewCarBrendForm construct() {
    return new NewCarBrendForm();
    }
    
    @RequestMapping(value = "/addcarbrend", method = RequestMethod.GET)        
    public ModelAndView addCarBrend(ModelAndView model) {
        
        return model;
    }
    
    @RequestMapping(value = "/addcarbrend",method = RequestMethod.POST)
    public ModelAndView carBrendAdded(@Valid final NewCarBrendForm newCarBrendForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors()) {
            return model;
	}
        if(carBrendService.findByName(newCarBrendForm.getBrendName().trim()) != null ){
            result.rejectValue("brendName", "error.newCarBrendForm", "Brend already exists");
            return model;
        }
    
        CarBrend carBrend = new CarBrend();
        carBrend.setBrendName(newCarBrendForm.getBrendName());
        
        if(carBrendService.save(carBrend) != null){
            model.setViewName("message");
            model.addObject("message", "brend_added");
            
            return model;
        }
            model.setViewName("error");
            model.addObject("message", "Brend not added, something goes wrong");
            
            return model;
    }
}
