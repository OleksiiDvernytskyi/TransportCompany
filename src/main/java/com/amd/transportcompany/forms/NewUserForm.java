/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.forms;

import com.amd.transportcompany.controllers.FieldEquals;
import com.amd.transportcompany.entities.UserRole;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
/**
 *
 * @author amd
 */
@FieldEquals( field="password", equalsTo="confirmPassword" )
public class NewUserForm {
	@NotBlank
        @Size(min=3, max=20)
        private String username;
	
        @NotBlank
        private String lastname;
        
        @NotBlank
        private String firstname;
        
        @NotBlank
        @Size(min = 9, max=14)
        private String phone;
        
        @NotBlank
        @Size(min=3, max=20)
        private String password;
        private String confirmPassword;
        private UserRole role;

    public NewUserForm() {
        this.role = UserRole.DRIVER;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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