/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.repositories;

import com.amd.transportcompany.entities.Car;
import java.util.List;

/**
 *
 * @author a
 */
public interface CarRepository {
    
    public Long save(Car car);
    public List<Car> readAll();

    public Car findByIg(Long carId);

    public Car findByName(String name);
    
    
}
