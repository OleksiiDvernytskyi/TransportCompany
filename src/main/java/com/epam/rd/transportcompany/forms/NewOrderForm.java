/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author a
 */
public class NewOrderForm {
    
    @NotBlank
    private String phone;
    
    @NotBlank
    private String fromWhere;
    private String toWhere;
    
    @DecimalMax(value = "100" )
    private Long passengers;
    @DecimalMax(value = "100" )
    private Long cargo;

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

    public Long getCargo() {
        return cargo;
    }

    public void setCargo(Long cargo) {
        this.cargo = cargo;
    }
    
    
}
