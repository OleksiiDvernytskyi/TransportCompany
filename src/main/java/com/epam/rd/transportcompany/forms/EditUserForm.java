/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import com.epam.rd.transportcompany.controllers.FieldEquals;
import com.epam.rd.transportcompany.entities.Car;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author a
 */
@FieldEquals( field="password", equalsTo="confirmPassword" )
public class EditUserForm {
   
        private boolean disabled;
        private String username;
        @NotBlank
        private String lastname;
        
        @NotBlank
        private String firstname;
        
        @NotBlank
        @Size(min = 9, max=14)
        private String phone;
        
        private String password;
        private String confirmPassword;
        private UserRole role;
        
    public EditUserForm() {
    }

    public EditUserForm(User user) {
        this.username = user.getUsername();
        this.disabled = user.isDisabled();
        this.lastname = user.getLastName();
        this.firstname = user.getFirstName();
        this.phone = user.getPhone();
        this.role = user.getUserRole();
        if(user.getCar() != null){
        }
    }

   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
        
        
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
        
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
