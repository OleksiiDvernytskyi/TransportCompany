/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author a
 */
@Entity
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String carModel;
    
    private Long passengers;
    private Long cargo;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Long getCargo() {
        return cargo;
    }

    public void setCargo(Long cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.carId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.carId, other.carId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", carModel=" + carModel + ", passengers=" + passengers + ", cargo=" + cargo + '}';
    }
    
    
}
