/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.services;

import com.amd.transportcompany.entities.Car;
import java.util.List;

/**
 *
 * @author a
 */
public interface CarService {
    public Long saveCar(Car car);
    public List<Car> readAll();
    public Car findByName(String name);

    public Car findById(Long carId);
}
