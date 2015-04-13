/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 *
 * @author a
 */
public class NewCarForm {
    
    @NotBlank
    @Size(min=3, max=20)
    private String carModel;
    
    @Range(min = 1, max = 120)
    private Long passengers;
    
    @Range(min = 0, max = 120)
    private Long cargo;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Long getPassengers() {
        return passengers;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public Long getCargo() {
        return cargo;
    }

    public void setCargo(Long cargo) {
        this.cargo = cargo;
    }
    
    
}
