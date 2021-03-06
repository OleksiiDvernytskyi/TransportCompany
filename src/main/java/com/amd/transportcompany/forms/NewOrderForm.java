/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.forms;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author a
 */
public class NewOrderForm {
    
    @NotBlank
    @Size(min = 9, max=14)
    private String phone;
    
    @NotBlank
    @Size(max=25)
    private String fromWhere;
    @Size(max=25)
    private String toWhere;
    
    @DecimalMax(value = "100" )
    private Long passengers;
    @DecimalMax(value = "1000" )
    private Long carCategory;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
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
