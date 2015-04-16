/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author amd
 */
public class NewCarBrendForm {
    @NotBlank
    @Size(max=20)
    private String brendName;

    public String getBrendName() {
        return brendName;
    }

    public void setBrendName(String brendName) {
        this.brendName = brendName;
    }
    
}
