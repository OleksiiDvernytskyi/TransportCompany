/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.Car;
import com.epam.rd.transportcompany.repositories.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service("carService")
public class JpaCarService implements CarService{
    
    @Autowired 
    private CarRepository carRepository;

    @Override
    public Car newCar(){
        return new Car();
    }
    
    @Override
    public Long saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Car findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
