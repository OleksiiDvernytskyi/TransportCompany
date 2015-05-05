/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import com.epam.rd.transportcompany.controllers.FieldEquals;
import com.epam.rd.transportcompany.entities.User;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author a
 */
@FieldEquals( field="password", equalsTo="confirmPassword" )
public class EditProfileForm {
    private boolean ready;     
    private String username;
    
    @NotBlank
    @Size(min = 9, max=14)
    private String phone;
        
    private String password;
    private String confirmPassword;
    private Long carId;

    public EditProfileForm() {
    }

    public EditProfileForm(User user) {
        this.ready = user.isReady();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        if(user.getCar() != null){
        this.carId = user.getCar().getCarId();
        }
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    
    
}
