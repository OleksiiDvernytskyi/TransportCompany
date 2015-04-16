/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.controllers;

import com.epam.rd.transportcompany.entities.Car;
import com.epam.rd.transportcompany.forms.NewCarForm;
import com.epam.rd.transportcompany.services.CarService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author amd
 */
@Controller
public class NewCarController {
 
    @Autowired
    @Qualifier("carService")
    private CarService carService;
    
    @ModelAttribute("newCarForm")
    public NewCarForm construct() {
    return new NewCarForm();
 }
    
    @RequestMapping(value = "/addcar", method = RequestMethod.GET)        
    public ModelAndView addCar(ModelAndView model) {

        return model;
    }
   
    @RequestMapping(value = "/addcar",method = RequestMethod.POST)
    public ModelAndView carAdded(@Valid final NewCarForm newCarForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors()) {
            return model;
	}
        
         if(carService.findByName(newCarForm.getCarModel().trim()) != null ){
            result.rejectValue("carModel", "error.newCarForm", "Car model already exists");
            return model;
        }
        
        Car newCar = new Car();
        newCar.setCarModel(newCarForm.getCarModel());
        newCar.setPassengers(newCarForm.getPassengers());
        newCar.setCargo(newCarForm.getCargo());
        
        carService.saveCar(newCar);
        if(newCar.getCarId() != null){
            model.addObject("newCar", newCar);
            model.setViewName("caradded");
        }else{ 
            model.setViewName("error");
            model.addObject("message", "Car not added, something goes wrong");
        }
        
        return model;
        
    }
}
