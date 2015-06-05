/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.controllers;

import com.amd.transportcompany.entities.Car;
import com.amd.transportcompany.entities.CarBrend;
import com.amd.transportcompany.forms.NewCarForm;
import com.amd.transportcompany.services.CarBrendService;
import com.amd.transportcompany.services.CarService;
import java.util.List;
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
    
    @Autowired
    private CarBrendService carBrendService;
    
    @ModelAttribute("newCarForm")
    public NewCarForm construct() {
    return new NewCarForm();
    }
    
    @RequestMapping(value = "/addcar", method = RequestMethod.GET)        
    public ModelAndView addCar(ModelAndView model) {

        List<CarBrend> brendList = carBrendService.readAll();

        model.addObject("brendList", brendList);
        return model;
    }
   
    @RequestMapping(value = "/addcar",method = RequestMethod.POST)
    public ModelAndView carAdded(@Valid final NewCarForm newCarForm, final BindingResult result, ModelAndView model) {
	if (result.hasErrors()) {
            return model;
	}
        if(newCarForm.getBrendId() == 0 ){
            result.rejectValue("brendId", "error.newCarForm", "Brend not selected");
            return model;
        }
         if(carService.findByName(newCarForm.getCarModel().trim()) != null ){
            result.rejectValue("carModel", "error.newCarForm", "Car model already exists");
            return model;
        }
        
        Car newCar = new Car();
        newCar.setCarModel(newCarForm.getCarModel());
        newCar.setPassengers(newCarForm.getPassengers());
        newCar.setCarCategory(newCarForm.getCarCategory());
        newCar.setBrend(carBrendService.findById(newCarForm.getBrendId()));
        
        carService.saveCar(newCar);
        if(newCar.getCarId() != null){
            model.addObject("newCar", newCar);
            model.setViewName("caradded");
        }else{ 
            model.setViewName("error");
            model.addObject("message", "car_not");
        }
        
        return model;
        
    }
}

