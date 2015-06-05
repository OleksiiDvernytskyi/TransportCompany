/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.forms;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 *
 * @author a
 */
public class NewCarForm {
    
    @NotBlank
    @Size(min=2, max=20)
    private String carModel;
    
    @Range(min = 1, max = 20)
    private Long passengers;
    
    @Range(min = 1, max = 10)
    private Long carCategory;

    private Long brendId;

    public Long getBrendId() {
        return brendId;
    }

    public void setBrendId(Long brendId) {
        this.brendId = brendId;
    }

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

    public Long getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Long carCategory) {
        this.carCategory = carCategory;
    }
    
    
}
