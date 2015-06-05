/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author a
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Car.readAll",
            query = "SELECT u FROM Car u ORDER BY u.brend.brendName"),
    @NamedQuery(name = "Car.findByModel",
            query = "SELECT u FROM Car u WHERE u.carModel =:name"),
})
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    
    @Column(unique = true)
    private String carModel;
    
    @ManyToOne
    @JoinColumn(name = "brendId")
    private CarBrend brend;
    
    private Long passengers;
    private Long carCategory;

    public CarBrend getBrend() {
        return brend;
    }

    public void setBrend(CarBrend brend) {
        this.brend = brend;
    }

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

    public Long getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Long carCategory) {
        this.carCategory = carCategory;
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
        return "Car{" + "carId=" + carId + ", carModel=" + carModel + ", passengers=" + passengers + ", carCategory=" + carCategory + '}';
    }
    
    
}
